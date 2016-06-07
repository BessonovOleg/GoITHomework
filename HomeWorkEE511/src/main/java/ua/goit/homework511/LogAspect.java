package ua.goit.homework511;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
        new LogWriter(pjp.getSignature().getName());
        Object result;
        result = pjp.proceed();
        return result;
    }
}
