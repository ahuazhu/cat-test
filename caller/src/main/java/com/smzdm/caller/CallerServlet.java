package com.smzdm.caller;

import com.dianping.cat.Cat;
import com.smzdm.cat.Context;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhengwenzhu on 16/10/12.
 */
public class CallerServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) {

        Resource res = new ClassPathResource("appcontext-beans.xml");
        BeanFactory factory = new XmlBeanFactory(res);

        TestService testService = (TestService) factory.getBean("testService");

        String path = request.getPathInfo();
        if ("/hello".equals(path)) {
            testService.world();
        }
    }

}