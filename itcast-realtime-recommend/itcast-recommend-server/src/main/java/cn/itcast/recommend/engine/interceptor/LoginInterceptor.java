package cn.itcast.recommend.engine.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String uri = request.getRequestURL().toString();
		String param = request.getQueryString();
		System.out.println("LoginInterceptor print param: "+param);
		System.out.println("LoginInterceptor print uri: "+uri);
		if (uri.contains("login")) {
			return true;
		}
		// a)拦截用户请求，判断用户是否登录
		HttpSession session = request.getSession();
		Object username = session.getAttribute("username");
		if (username != null) {
			System.out.println("------------------+++++++---"+username);
			// b)如果用户已经登录。放行
			return true;
		}
		// c)如果用户未登录，跳转到登录页面。
		if (StringUtils.isNotBlank(param)) {
			response.sendRedirect(request.getContextPath() + "/login/index.html?reURL=" + uri + "?" + param);
		}else{
			response.sendRedirect(request.getContextPath() + "/login/index.html?reURL=" + uri);
		}
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
