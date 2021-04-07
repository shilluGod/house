package com.shillu.server.config.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/2/21 16:15
 *
 * JwtToken工具类
 */
@Component      //标注Spring管理的Bean，使用@Component注解在一个类上，表示将此类标记为Spring容器中的一个Bean。
public class JwtTokenUtil {

    // 准备-用户名和时间
    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    //密钥、失效时间在yml文件里面读取
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据用户信息生成Token
     * @param userDetails 用户信息获取
     * @return generateToken(claims)
     */
    public String generateToken(UserDetails userDetails){

        // 准备一个荷载
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return  generateToken(claims);
    }

    /**
     * 从token中获取登录用户名
     * @param token token
     * @return username
     */
    public String getUserNameFromToken(String token){
        String username;
        // 拿去一个荷载
        try {
            Claims claims = getClaimsFormToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证token是否有效
     * @param token token
     * @param userDetails 用户信息获取
     * @return 判断结果
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否被刷新
     * @param token token
     * @return canRefresh
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token token
     * @return refreshToken
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFormToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * 验证token是否有效中isTokenExpired()方法
     * @param token token
     * @return isTokenExpired
     */
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     * @param token token
     * @return getExpiredDateFromToken
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }


    /**
     * 从token中获取荷载
     * @param token token
     * @return getClaimsFormToken
     */
    private Claims getClaimsFormToken(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }


    /**
     * 根据荷载生成JWT TOKEN
     * @param claims 荷载
     * @return generateToken
     */
    private String generateToken(Map<String,Object> claims){
        // 通过Jwts来生成
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成token失效时间
     * @return generateExpirationDate
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration *1000);
    }
}
