package net.seehope.spring.mock.servlet;

import org.springframework.stereotype.Controller;

/*@Configuration 配置文件
@Controller 控制器
@Service 服务
@Repository 仓库/mapper/dao
@Component 其他组件*/
@Controller
public class MockServlet1 extends MockHttpServlet {

	@Override
	public void init() {
		System.out.println("init MockServlet1");
	}

	@Override
	public void service() {
		System.out.println("service MockServlet1");
	}

	@Override
	public void detsory() {
		System.out.println("indetsoryit MockServlet1");
	}

}
