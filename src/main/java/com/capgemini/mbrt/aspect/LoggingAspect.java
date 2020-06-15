package com.capgemini.mbrt.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution(* com.capgemini.mbrt.controller..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        ObjectMapper mapper = new ObjectMapper();
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        Object[] array = proceedingJoinPoint.getArgs();
        logger.info(className+" : "+ methodName +"() method invoked. arguments : "
                +mapper.writeValueAsString(array));
        final StopWatch stopWatch = new StopWatch();
        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        logger.info(className+" : "+methodName +"() Response : "
                +mapper.writeValueAsString(result));
        //Log method execution time
        logger.info("Execution time of " + className + "." + methodName + "() "
                + ": " + stopWatch.getTotalTimeMillis() + " ms");
        return result;
    }
}
