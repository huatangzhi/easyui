package com.superbool.easyui.cas;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.SpringConfiguredConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@Configuration
public class casConfig {

    private static boolean casEnabled  = true;

    @Bean
    public ServletContextInitializer initializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setInitParameter("casServerLogoutUrl", "http://ids.chd.edu.cn/authserver/logout");
            }
        };
    }


    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListener() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> listener = new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>();
        listener.setEnabled(casEnabled);
        listener.setListener(new SingleSignOutHttpSessionListener());
        listener.setOrder(1);
        return listener;
    }

    @Bean
    public FilterRegistrationBean casSingleSignOut() {
        FilterRegistrationBean casSingle = new FilterRegistrationBean();
        casSingle.setFilter(new SingleSignOutFilter());
        casSingle.addUrlPatterns("/*");
        return casSingle;
    }

    @Bean
    public FilterRegistrationBean casValidation() {
        FilterRegistrationBean casValidation = new FilterRegistrationBean();
        casValidation.setFilter(new Cas20ProxyReceivingTicketValidationFilter());
        casValidation.addInitParameter("casServerUrlPrefix", "http://ids.chd.edu.cn/authserver");
        casValidation.addInitParameter("serverName", "http://202.117.64.170:10934");
//        casValidation.addInitParameter("serverName", "http://info.chd.edu.cn");
//        casValidation.addInitParameter("useSession", "true");
//        casValidation.addInitParameter("exceptionOnValidationFailure", "true");
//        casValidation.addInitParameter("redirectAfterValidation", "true");
        casValidation.addUrlPatterns("/*");
        casValidation.addInitParameter("encoding", "UTF-8");
        return casValidation;
    }

    @Bean
    public FilterRegistrationBean casAuthentication() {
        FilterRegistrationBean casAuth = new FilterRegistrationBean();
        casAuth.setFilter(new AuthenticationFilter());
        casAuth.addInitParameter("casServerLoginUrl", "http://ids.chd.edu.cn/authserver/login");
        casAuth.addInitParameter("serverName", "http://202.117.64.170:10934");
//        casAuth.addInitParameter("serverName", "http://info.chd.edu.cn");
        casAuth.addUrlPatterns("/*");
        casAuth.addInitParameter("encoding", "UTF-8");
        return casAuth;
    }



    @Bean
    public FilterRegistrationBean casHttpServletRequestWrapper () {
        FilterRegistrationBean casValidation = new FilterRegistrationBean();
        casValidation.setFilter(new HttpServletRequestWrapperFilter());
        casValidation.addUrlPatterns("/*");
        return casValidation;
    }
}

