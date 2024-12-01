package com.example.demo.config;

import java.util.function.Supplier;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSession;

@Component
public class CustomAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
        HttpSession session = context.getRequest().getSession(false);
        if (session == null) {
            return new AuthorizationDecision(false);
        }

        Long userId = Utils.getSessionUUID(session);
        String username = Utils.getSessionUsername(session);
        if (userId < 0 || username == "") {
            return new AuthorizationDecision(false);
        }

        return new AuthorizationDecision(true);
    }
}