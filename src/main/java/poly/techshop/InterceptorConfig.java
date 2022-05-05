package poly.techshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import poly.techshop.interceptor.Globallnterceotor;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
@Autowired
Globallnterceotor goGloballnterceotor;

@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(goGloballnterceotor)
	.addPathPatterns("/**")
	.excludePathPatterns("/rest/**","/admin/**","/assets/**");
	}
}
