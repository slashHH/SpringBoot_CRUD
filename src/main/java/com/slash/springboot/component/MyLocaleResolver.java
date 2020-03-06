package com.slash.springboot.component;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        System.out.println("getting parameter...");
        Locale locale = Locale.getDefault();
        System.out.println("default locale is :"+locale);
        if (!StringUtils.isEmpty(l)) {
            String[] s = l.split("_");
            locale =new Locale(s[0], s[1]);
            System.out.println("new locale is :"+locale);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
