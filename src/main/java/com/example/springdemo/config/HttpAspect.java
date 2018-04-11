package com.example.springdemo.config;

import com.example.springdemo.utils.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.example.springdemo.controller.*.*(..))")
    public void log() {
    }

    /**
     * 在切点之前获取请求相关信息
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder httpInfo = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            map.put(paraName, request.getParameter(paraName));
        }
        httpInfo.append("[URI=").append(request.getRequestURI()).append("][method=").append(request.getMethod())
                .append("][ip=").append(request.getRemoteAddr()).append("][params=");

        if (null != map && map.size() > 0) {
            httpInfo.append(JsonUtils.objectToJson(map));
        }
        httpInfo.append("]");
        logger.info("request = {}",httpInfo);

    }

    @After("log()")
    public void doAfter() {
    }

    /**
     * 记录请求完成之后的响应体
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", JsonUtils.objectToJson(object));
    }
}
