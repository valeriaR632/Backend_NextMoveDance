package nmdc.nmdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import nmdc.nmdc.config.JwtFilter;

@SpringBootApplication
public class NmdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmdcApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/usuarioRegitrado/*");//agrega un aptron de loq ue queire filtrar, todo lo que diga /api/prosutos
		registrationBean.addUrlPatterns("/api/clases/*");
		return registrationBean;

	}

}
