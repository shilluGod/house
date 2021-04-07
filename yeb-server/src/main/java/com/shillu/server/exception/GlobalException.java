package com.shillu.server.exception;

import com.shillu.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/3/9 14:34
 *
 * 全局异常
 */
@RestControllerAdvice       // 控制器增强类
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据存在关联数据，操作不允许!");
        }
        return RespBean.error("数据库异常，操作不允许!");
    }
}
