package ir.chica.task.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(public void ir.chica.task.service.*.save*(..))")
    public void forServiceSaveMethod(){
    }

    @Pointcut("execution(public void ir.chica.task.service.*.get*(..))")
    public void forServiceGetMethods(){}

    @Pointcut("execution(public void ir.chica.task.service.*.*(..))")
    public void forTransactionAnnotation(){

    }
}
