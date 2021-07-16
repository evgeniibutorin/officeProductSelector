package com.example.officeProductSelector.filters;

import com.example.officeProductSelector.components.ActiveUser;
import com.example.officeProductSelector.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter
//public class RegistrationFilter extends OncePerRequestFilter {
public class RegistrationFilter implements Filter, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private UserService userService;
    private FilterConfig filterConfig;

    private ActiveUser activeUser;

    public RegistrationFilter(UserService userService) {
        this.userService = userService;
    }

    public RegistrationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
//        this.activeUser = applicationContext.getBean(ActiveUser.class);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Boolean isActive = (Boolean) request.getSession().getAttribute("isActive");
        if (!Boolean.TRUE.equals(isActive)) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendRedirect("http://localhost:9090/officeProductSelector_war_exploded/authorization");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }


    @Override
    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.activeUser = applicationContext.getBean(ActiveUser.class);
    }
}
