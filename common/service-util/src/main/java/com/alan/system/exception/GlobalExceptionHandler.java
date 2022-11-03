package com.alan.system.exception;

import com.alan.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/11/1 21:02
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        return Result.fail().message("执行了全局异常处理");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        return Result.fail().message("执行了除零异常处理");
    }

    @ExceptionHandler(AlanException.class)
    @ResponseBody
    public Result error(AlanException e) {
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }


}
