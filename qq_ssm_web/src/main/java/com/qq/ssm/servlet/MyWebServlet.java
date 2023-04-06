package com.qq.ssm.servlet;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * CLASS Simple Description //TODO <br><br>
 *
 * <p>
 * Class detailed description, effection, usage,etc. //TODO
 * </p >
 * <br>
 * author: qiqin 2022/8/9 12:09
 */
@WebServlet(name = "myWebServlet" ,urlPatterns = {"*.do","*.action"})
public class MyWebServlet extends HttpServlet {
}
