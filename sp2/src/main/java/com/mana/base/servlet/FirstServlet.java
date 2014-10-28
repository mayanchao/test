package com.mana.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("*.do")
public class FirstServlet extends HttpServlet {
    
//    final static Logger LOG = LoggerFactory.getLogger(FirstServlet.class);
    
    private static final long serialVersionUID = 6833688147345340845L;

    
    public void init() throws ServletException {
    	System.out.println("init servlet start 222222222222222222222222");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        LOG.info("hello");
        PrintWriter out = response.getWriter();
        out.print("first servlet");
        out.flush();
        out.close();
        
    }


}