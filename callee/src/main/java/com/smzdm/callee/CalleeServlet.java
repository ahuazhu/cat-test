package com.smzdm.callee;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.dianping.cat.status.StatusExtensionRegister;
import com.smzdm.status.model.entity.RuntimeInfo;
import com.smzdm.callee.com.smzdm.monitor.Monitor;
import com.smzdm.cat.Context;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhengwenzhu on 16/10/12.
 */
public class CalleeServlet extends HttpServlet {

    private RuntimeInfo runtimeInfo = new RuntimeInfo();

    public CalleeServlet() {
        StatusExtensionRegister.getInstance().register(new Monitor());
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        if ("/world".equals(path)) {

            response.getWriter().write("{\"id\":3,\"name\":\"world\"}");
        } else if ("/callee/world".equals(path)){
            response.getWriter().write("{\"id\":3,\"name\":\"callee, world\"}");
        }

    }
}
