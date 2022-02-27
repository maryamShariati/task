package ir.chica.task.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class CheckingRole {

    @Before("execution(public void ir.chica.task.service.RoleService.saveRole(*))")

    public Boolean checkingRoles(JoinPoint joinPoint){
        if (joinPoint.equals("ADMIN")){
            return true;
        }else {
            return false;
        }
    }
}
