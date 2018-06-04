package com.example.springdemo.config;

import com.example.springdemo.utils.DateUtils;
import com.example.springdemo.utils.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.springdemo.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder httpInfo = new StringBuilder();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        String params = "";
        if (args != null && paramNames != null) {
            for (int i = 0; i < args.length; i++) {
                params += " " + paramNames[i] + ": " + args[i];
            }
        }

        httpInfo.append("[{DATE=").append(DateUtils.convertDateTimeToString(new Date())).append("},{URI=").append(request.getRequestURI()).append("},{method=").append(request.getMethod())
                .append("},{ip=").append(request.getRemoteAddr()).append("},{params=");

        if (!StringUtils.isEmpty(params)) {
            httpInfo.append(JsonUtils.objectToJson(params));
        }
        httpInfo.append("}]");
        logger.info("request = {}", httpInfo);

    }

    @After("log()")
    public void doAfter() {
    }

    /**
     * 记录请求完成之后的响应体
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", JsonUtils.objectToJson(object));
    }
}
