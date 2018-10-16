package com.icash.handler.security;

import com.google.gson.Gson;
import com.icash.model.ErrorMessage;
import com.icash.utils.ApplicationInstant;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    private Gson gson = new Gson();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ErrorMessage errorMessage = new ErrorMessage(authException.getMessage());

        String errorMessageString = this.gson.toJson(errorMessage);

        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(errorMessageString);
        out.flush();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(ApplicationInstant.ICASH_REALM);
        super.afterPropertiesSet();
    }
}
