package site.binghai.Interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.LineManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IceSea on 2017/5/25.
 * GitHub: https://github.com/IceSeaOnly
 */
public class LineManagerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("user");
        if(obj == null || !(obj instanceof LineManager)){
            response.sendRedirect("/login");
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
