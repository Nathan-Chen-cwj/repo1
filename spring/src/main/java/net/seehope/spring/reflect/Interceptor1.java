package net.seehope.spring.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class Interceptor1 implements Interceptor {

	@Override
	public boolean before(Object ori, Object proxy, Method method, Object[] args) {
		System.out.println("Interceptor1 before");
		return true;
	}

	@Override
	public Object around(Object ori, Object proxy, Method method, Object[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Interceptor1 around");
		return method.invoke(ori, args);
	}

	@Override
	public void afterReturning(Object ori, Object proxy, Method method, Object[] args, Object result) {
		System.out.println(new Date() + "  :  " + " 使用了参数" + Arrays.toString(args) + "  调用了 " + method.getName()
				+ "   方法  " + " 并且得到了 " + result + " 结果");
	}

	@Override
	public void afterThrowing(Object ori, Object proxy, Method method, Object[] args, Exception e) {
		System.out.println("Interceptor1 afterThrowing");
		e.printStackTrace();
	}

	@Override
	public void after(Object ori, Object proxy, Method method, Object[] args) {
		System.out.println("Interceptor1 after");
	}

}
