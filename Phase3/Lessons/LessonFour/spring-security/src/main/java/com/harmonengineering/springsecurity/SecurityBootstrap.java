package com.harmonengineering.springsecurity;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.session.HttpSessionEventPublisher;

public class SecurityBootstrap extends AbstractSecurityWebApplicationInitializer
{
    protected boolean enableHttpSessionEventPublisher()
    {
        return true ;
    }
}
