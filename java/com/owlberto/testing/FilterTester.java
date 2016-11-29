package com.owlberto.testing;
import org.junit.Test;

import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class FilterTester {
	
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}

    @Test
    public void ordersPathParamTest() {
//    	Resp resp = HttpUtil.HttpGet("http://localhost:8080/Accounts/user/test");
//        String response = resp.getBody();
//        System.out.println(response);
    }

}
