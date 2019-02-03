package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class LoggerAspect {

    private final static Logger LOG = LoggerFactory.getLogger(LoggerAspect.class.getName());

    @Pointcut("execution(* pages.*.*(..))")
    public void loggableMethod() {
    }

    @Around("loggableMethod()")
    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        LOG.info("Step START " + methodName);

        Object result = thisJoinPoint.proceed();

        LOG.info("Step DONE " + methodName + " / " + result);

        return result;
    }


}