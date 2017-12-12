package com.yuan.www.config.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.WebAppRootListener;

import com.yuan.www.config.spring.SpringConfig;

public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		initializeSpringConfig(servletContext);// 加载spring配置文件
		initializeSpringMVCConfig(servletContext);// 加载spring mvc配置文件
		initializeLog4jConfig(servletContext);

	}

	private void initializeSpringConfig(ServletContext container) {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringConfig.class);
		// Manage the life cycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
	}

	private void initializeSpringMVCConfig(ServletContext container) {
		// Create the spring rest servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(SpringMVCConfig.class);

		// Register and map the spring rest servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("SpringMvc",
				new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(2);
		dispatcher.setAsyncSupported(true);
		dispatcher.addMapping("/");
	}

	private void initializeLog4jConfig(ServletContext container) {
		// Log4jConfigListener
		container.setInitParameter("log4jConfigLocation", "classpath:log4j.properties");

		container.addListener(WebAppRootListener.class);
	}
}
