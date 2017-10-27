package com.example.demo.handle;

import com.example.demo.exception.GrilException;
import com.example.demo.model.Result;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GrilException) {
            GrilException grilException = (GrilException) e;
            return ResultUtil.error(grilException.getCode(), grilException.getMessage());
        }
        logger.error("[系统错误] {}", e);
        return ResultUtil.error(-1, "未知错误");
    }
}
