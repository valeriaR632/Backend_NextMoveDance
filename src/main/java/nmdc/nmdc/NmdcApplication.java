package nmdc.nmdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NmdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmdcApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<JwtFilter>jwFilter(){
		FilterRegistrationBean<JwtFilter>registrationBean=
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwFilter));
		registrationBean.addUrlPatterns("/api/clases/*");
		registrationBean.addUrlPatterns("/api/usuariosRegistrados/*");
		return registrationBean;
	}

}
