package ir.chica.task.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenUtil {
    public boolean validate(String token){
        return true;
    }
}
