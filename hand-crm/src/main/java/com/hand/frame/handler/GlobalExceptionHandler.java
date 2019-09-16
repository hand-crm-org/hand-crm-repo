package com.hand.frame.handler;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 异常统一处理
 * @author nan.yao@hand-china.com 2019/9/16 17:06
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private ResultDTO exceptionHandler(HttpServletRequest req, Exception e){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        return ResultDTO.error(e.getMessage());
    }
}
