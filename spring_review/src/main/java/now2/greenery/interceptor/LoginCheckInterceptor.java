package now2.greenery.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		log.info("실행");
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		LoginCheck loginCheck = handlerMethod.getMethodAnnotation(LoginCheck.class);
	
		if(loginCheck == null) {
			log.info("@LoginCheck가 붙어 있지 않음");
		} else {
			log.info("@LoginCheck가 붙어 있음");
			
			HttpSession session = request.getSession();
			String login = (String) session.getAttribute("login");
			
			if(login == null) {
				String contextPath = request.getServletContext().getContextPath();
				response.sendRedirect(contextPath + "/ch02/loginFrom");
				return false;
			} else {
				//로그인을 했을 경우
				
			}
		}
		
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
		log.info("실행");
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws IOException {
		log.info("실행");
	}
	
}
