package ir.chica.task.aspect;

import ir.chica.task.service.TransactionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.transaction.annotation.Transactional;

@Aspect
public class Transaction {



    @Transactional
    @Around( " ir.chica.task.service.*.*(..)   " )
    public Object interceptServiceLayer( ProceedingJoinPoint pjp ) throws Throwable
    {
        return pjp.proceed();
    }


//    private TransactionService transactionService = new TransactionService();
//
//    @Transactional
//    @Before("ir.chica.task.aspect.Pointcuts.forTransactionAnnotation()")
//    public void beforeTransactionalMethod(JoinPoint joinPoint) {
//        transactionService.beginTransaction();
//    }
//
//    @AfterReturning("ir.chica.task.aspect.Pointcuts.forTransactionAnnotation()")
//    public void afterTransactionalMethod(JoinPoint joinPoint) {
//        transactionService.commit();
//    }
//
//    @AfterThrowing(pointcut = "ir.chica.task.aspect.Pointcuts.forTransactionAnnotation()",
//            throwing = "e")
//    public void afterThrowingFromTransactionalMethod(JoinPoint joinPoint,
//                                                     RuntimeException e) {
//        transactionService.rollback();
//    }


}

