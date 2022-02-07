package ir.chica.task.exception;

public class UsernameNotFoundException extends Throwable {
    public UsernameNotFoundException(Object param){

        super("Invalid credential");
    }
}
