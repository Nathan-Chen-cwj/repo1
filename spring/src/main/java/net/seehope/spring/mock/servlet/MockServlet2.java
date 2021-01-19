package net.seehope.spring.mock.servlet;

import org.springframework.stereotype.Controller;

@Controller
public class MockServlet2 extends MockHttpServlet {

	@Override
	public void init() {
		System.out.println("init MockServlet2");
	}

	@Override
	public void service() {
		System.out.println("service MockServlet2");
	}

	@Override
	public void detsory() {
		System.out.println("indetsoryit MockServlet2");
	}

}