package com.smzdm.callee;

import com.dianping.cat.status.StatusExtensionRegister;
import com.smzdm.callee.com.smzdm.monitor.Monitor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhengwenzhu on 16/10/12.
 */
public class CalleeServlet extends HttpServlet {

    public CalleeServlet() {
        StatusExtensionRegister.getInstance().register(new Monitor());
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        if ("/world".equals(path)) {

            response.getWriter().write("{\"id\":3,\"name\":\"world\"}");
        } else if ("/callee/world".equals(path)) {
            response.getWriter().write("{\"id\":3,\"name\":\"callee, world\"}");
        }

    }
}
