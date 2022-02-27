package ir.chica.task.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {


    @Around("( ir.chica.task.aspect.Pointcuts.forServiceGetMethods()|| ir.chica.task.aspect.Pointcuts.forServiceSaveMethod())")
    public Object logInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Duration Log: " + duration + " millisecond");

        return result;
    }



    @Around("ir.chica.task.service.TaskService.updateNameById(*,*))")
    public Object logInfoEx2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Duration Log: " + duration + " millisecond");
        return result;
    }

}
