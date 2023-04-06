package com.qq.ssm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * CLASS Simple Description //TODO <br><br>
 *
 * <p>
 * Class detailed description, effection, usage,etc. //TODO
 * </p >
 * <br>
 * author: qiqin 2022/8/9 11:29
 */
@WebFilter(urlPatterns={"/index/index.do","/index1.do"},
        servletNames = "myServlet",
        filterName ="myWebFilter",
        dispatcherTypes =DispatcherType.INCLUDE )
public class MyWebFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器执行");
        //过滤器链，继续执行下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}