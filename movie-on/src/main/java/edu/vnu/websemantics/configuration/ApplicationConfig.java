package edu.vnu.websemantics.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * This is the default class that will load all the spring related
 * configurations.
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan("edu.vnu.websemantics")
//@Import({ SecurityConfig.class, DBConfig.class })
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(getViewResolver());
	}

	/**
	 * This method will resolve the resource path to the views.
	 *
	 * @return the InternalResourceViewResolver object
	 */



	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

//	@Bean
//	public View sample() {
//		return new JstlView("/WEB-INF/page/login.jsp");
//	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}

	// equivalent for <mvc:default-servlet-handler/> tag
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable("login");
	}

}
