package com.smzdm.callee;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhengwenzhu on 16/10/12.
 */
public class CalleeServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        if ("/world".equals(path)) {

            response.getWriter().write("{\"id\":3,\"name\":\"world\"}");
        } else if ("/callee/world".equals(path)) {
            response.getWriter().write("{\"id\":3,\"name\":\"callee, world\"}");
        }

    }
}
