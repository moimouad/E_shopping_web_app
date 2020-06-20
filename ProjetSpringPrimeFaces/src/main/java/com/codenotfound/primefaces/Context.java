package com.codenotfound.primefaces;

import org.springframework.context.ApplicationContext;

public class Context {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext context) {
		Context.context = context;
	}
	
	

}
