package com.spring.api.demo3;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.api.demo3.service.ReleaseService;

@Component
public class Test implements InitializingBean {

	@Autowired
	ApplicationContext ctx;

	@Autowired
	private ReleaseService formatter;

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println(ctx.containsBean("formatter"));
		System.out.println(" <<<<< >>>>>"+ctx.getBean("releaseService").getClass());

	}

}
