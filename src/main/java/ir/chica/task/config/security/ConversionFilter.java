package ir.chica.task.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Component
@RequiredArgsConstructor
public class ConversionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String header = request.getHeader(HttpServletRequest.CLIENT_CERT_AUTH);
        if (header.isEmpty() || !header.contains("ة")){
            filterChain.doFilter(request, response);
            return;
        }
        header.replace("ة","ت");
        filterChain.doFilter(request,response);

    }
}
