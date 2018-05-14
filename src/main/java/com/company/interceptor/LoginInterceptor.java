package com.company.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String loginUrl=httpServletRequest.getRequestURI();
        System.out.println(loginUrl);
       if (loginUrl.indexOf("login.action") >=0)
       {
          System.out.println("Login preHandle run!");
          return true;
       }
        if (httpServletRequest.getHeader("x-requested-with") != null && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){  
             System.out.print("ajax");
             return true;
         }
       if (loginUrl.indexOf(".css") >=0)
       {
          System.out.println("Login preHandle run!");
          return true;
       }
       //System.out.println(httpServletRequest.getRequestURI());
        HttpSession session =httpServletRequest.getSession();
        
       String id= (String)session.getAttribute("loginId");
       //String passwd= (String)session.getAttribute("passwd");
      System.out.println(id);
      //System.out.println(passwd);
       if(id !=null){
          System.out.println("docInfo preHandle run!");
          return true;
       }
       httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        return false; 
    }

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
		throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
		throws Exception {
		// TODO Auto-generated method stub
	
	}
}