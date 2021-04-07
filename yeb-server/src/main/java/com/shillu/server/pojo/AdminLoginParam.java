package com.shillu.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/2/22 11:31
 *
 * 用户登录实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)       /*lombok里面的注解：自动的给model bean实现equals方法和hashcode方法*/
@Accessors(chain = true)        /*lombok里面的注解：注解用来配置lombok如何产生和显示getters和setters的方法*/
@ApiModel(value = "AdminLogin", description = "")   /*swagger注解，调用api文档*/
public class AdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;
}
