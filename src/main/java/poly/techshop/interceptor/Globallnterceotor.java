package poly.techshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import poly.techshop.service.CategoryService;

@Component
public class Globallnterceotor implements HandlerInterceptor {
@Autowired
CategoryService categoryService;
@Override
// vì sau khi thực hiện 1 phuowngt hức trong controller xong thì post mới chạy nên sử dụng hơn là pre
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	request.setAttribute("cates", categoryService.findAll());
	}
}
