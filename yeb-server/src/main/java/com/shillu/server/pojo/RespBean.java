package com.shillu.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/2/21 17:39
 *
 * 公共返回对象
 */
@Data
@NoArgsConstructor      //无参构造
@AllArgsConstructor     //全参构造
public class RespBean {
    private long code;  //状态码
    private String message;
    private Object object;

    /**
     * 成功返回结果
     * @param message message
     * @return 200..
     */
    public static RespBean success(String message){
        return new RespBean(200, message, null);
    }

    /**
     * 成功返回结果
     * @param message message
     * @param object object
     * @return 200...
     */
    public static RespBean success(String message, Object object){
        return new RespBean(200, message, object);
    }

    /**
     * 失败返回结果
     * @param message message
     * @return 500..
     */
    public static RespBean error(String message){
        return new RespBean(500, message, null);
    }

    /**
     * 失败返回结果
     * @param message message
     * @param object object
     * @return 500...
     */
    public static RespBean error(String message, Object object){
        return new RespBean(500, message, object);
    }
}
