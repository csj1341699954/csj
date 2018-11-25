package com.fh.shop.api.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public  static  void writeCookie(String name, String value, String domain, Integer maxAge, HttpServletResponse response){
        Cookie cookie = new Cookie(name,value);
        cookie.setDomain(domain);
        cookie.setPath("/");
        if(maxAge>0){
            cookie.setMaxAge(maxAge);
        }
        //写cookie
        response.addCookie(cookie);
    }

    public static  String  readCookie(String name, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length==0){
            return "";
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(name)){
               return cookie.getValue();
            }
        }
        return "";
    }

}
