package com.yuan.www.config.spring.mvc;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.Log4jConfigListener;
import org.springframework.web.util.WebAppRootListener;

import com.yuan.www.config.spring.SpringConfig;

public class WebInitializer implements WebApplicationInitializer  {

	

	/*protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return  new Class[] {SpringMVCConfig.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{ SpringConfig.class};
	}

	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}*/

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		initializeSpringConfig(servletContext);//加载spring配置文件
		 initializeSpringMVCConfig(servletContext);//加载spring mvc配置文件
     
		 /*  initializeLog4jConfig(servletContext);
           
        registerServlet(servletContext);

        registerListener(servletContext);

        registerFilter(servletContext);
        
		*/
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
        dispatcherContext.register(WebInitializer.class);

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
       // PropertyConfigurator.configureAndWatch(System.getProperty("rdm.home") + "/log4j.properties", 60);
    }
/*
    private void registerServlet(ServletContext container) {

        initializeStaggingServlet(container);
    }

    private void registerFilter(ServletContext container) {
        initializeSAMLFilter(container);
    }

    private void registerListener(ServletContext container) {
        container.addListener(RequestContextListener.class);
    }

    private void initializeSAMLFilter(ServletContext container) {
        FilterRegistration.Dynamic filterRegistration = container.addFilter("SAMLFilter", DelegatingFilterProxy.class);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
        filterRegistration.setAsyncSupported(true);
    }

    private void initializeStaggingServlet(ServletContext container) {
        StaggingServlet staggingServlet = new StaggingServlet();
        ServletRegistration.Dynamic dynamic = container.addServlet("staggingServlet", staggingServlet);
        dynamic.setLoadOnStartup(3);
        dynamic.addMapping("*.stagging");
    }*/
}
