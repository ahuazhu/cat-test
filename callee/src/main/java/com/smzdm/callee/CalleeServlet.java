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

            Transaction t = Cat.newTransaction("Service", path);
            Cat.logEvent("Service.client", request.getRemoteAddr());
            Cat.logEvent("Service.app", "client");

            Cat.Context context = new Context();
            context.addProperty(Cat.Context.CHILD, request.getHeader(Cat.Context.CHILD));
            context.addProperty(Cat.Context.ROOT, request.getHeader(Cat.Context.ROOT));
            context.addProperty(Cat.Context.PARENT, request.getHeader(Cat.Context.PARENT));
            Cat.logRemoteCallServer(context);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            t.setStatus(Transaction.SUCCESS);
            t.complete();
            response.getWriter().write("{\"id\":3}");
        } else if ("/callee/world".equals(path)){
            response.getWriter().write("{\"id\":3}");
        }

    }

    private Cat.Context logServer(HttpServletRequest request) {


        Cat.logEvent("Service.client", request.getRemoteAddr());
        Cat.logEvent("Service.app", "client");

        Cat.Context context = new Context();
        context.addProperty(Cat.Context.CHILD, request.getHeader(Cat.Context.CHILD));
        context.addProperty(Cat.Context.ROOT, request.getHeader(Cat.Context.ROOT));
        context.addProperty(Cat.Context.PARENT, request.getHeader(Cat.Context.PARENT));
        Cat.logRemoteCallServer(context);
        return context;
    }

}
