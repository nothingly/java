package com.woniu.controller.advice;

import com.woniu.controller.BaseController;
import com.woniu.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice extends BaseController {

    @ExceptionHandler
    public Result exceptionResole(Exception exception){
        exception.printStackTrace();
        // 记录异常
        log.debug("=====进入处理异常的公共方法=====", exception.getMessage());
        // 返回一个结果，告诉用户端处理失败了
        return error("系统繁忙,请稍后再试!");
    }

}
