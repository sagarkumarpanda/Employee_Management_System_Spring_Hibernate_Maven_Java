package com.hpSpring.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Controller
public class FontController extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
