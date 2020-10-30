package org.qinjie.handler;

import org.qinjie.entity.ResultCode;
import org.qinjie.entity.ResultVO;
import org.qinjie.exception.ApiException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * SpringBoot使用@RestControllerAdvice注解对@RestController的Controller进行异常处理
 * @author jieqin
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultVO<String> globalExceptionHandle(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVO<>(ResultCode.CHECK_EXCEPTION, objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = ApiException.class)
    public ResultVO<Object> apiExceptionHandle(ApiException e){
        return new ResultVO<>(ResultCode.USERNAME_PASSWORD_ERROR, e.getData());
    }

}
