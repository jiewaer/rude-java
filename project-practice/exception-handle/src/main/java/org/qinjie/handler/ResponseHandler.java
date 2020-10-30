package org.qinjie.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.qinjie.entity.ResultCode;
import org.qinjie.entity.ResultVO;
import org.qinjie.exception.ApiException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *  对响应结果进行封装，加上@RestControllerAdvice注解，并实现ResponseBodyAdvice接口，达到在接口返回的时候，对返回结果进行封装
 * @author jieqin
 */
@RestControllerAdvice(basePackages = {"org.qinjie.controller"})
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    /**
     * supports返回true的时候才执行beforeBodyWrite，进行返回值的封装，否则不执行beforeBodyWrite
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果方法返回类型不是ResultVo，则返回false，不进行处理
        return !methodParameter.equals(ResultVO.class);
    }

    /**
     * 将返回结果封装成ResultVo
     * @param t
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object t, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //返回String类型单独处理
        if(methodParameter.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVO<>(t));
            } catch (JsonProcessingException e) {
                throw new ApiException(ResultCode.STRING_EXCEPTION);
            }
        }
        return new ResultVO<>(t);
    }
}
