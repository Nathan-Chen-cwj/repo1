package net.seehope.spring.reflect;

import java.lang.reflect.Proxy;

/**
 * 
 * 代理对象必须有接口/父类 基于JDK实现的代理工厂
 * 
 * @author Monty
 *
 */
public class JDKProxyFactory {

	/**
	 * 传入原始对象，得到代理对象
	 * 
	 * @return
	 */
	public static Object binding(Object ori) {
		return Proxy.newProxyInstance(ori.getClass().getClassLoader(), ori.getClass().getInterfaces(),
				new JDKProxyProcessor(ori));
	}

	public static Object binding(Object ori, String interceptorName) {
		return Proxy.newProxyInstance(ori.getClass().getClassLoader(), ori.getClass().getInterfaces(),
				new JDKProxyProcessor(ori, interceptorName));
	}
}
