package ir.chica.task.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
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

//        **********************************

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = request.getReader();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }

        var jsonData = bufferedReader.toString();
        var attributes=jsonData.substring(1,jsonData.length()-1).split(",");

        for (String attribute:attributes) {
            var value=  attribute.split(":");
            if (value[1].contains("ة")){
                var newValue=value[1].replace("ة","ت");
                request.setAttribute(value[0],newValue);
            }
        }
        filterChain.doFilter(request,response);

    }


}
