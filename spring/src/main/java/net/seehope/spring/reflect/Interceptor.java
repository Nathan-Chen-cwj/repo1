package net.seehope.spring.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Interceptor {
	/**
	 * 前置通知 如果返回值为真，方法继续执行，如果为假，方法终止
	 * 
	 * @return
	 */
	boolean before(Object ori, Object proxy, Method method, Object[] args);

	/**
	 * 环绕通知 如果方法要被执行，那么只能在环绕通知中执行一次
	 * 
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	Object around(Object ori, Object proxy, Method method, Object[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 后置通知，方法执行之后，在这里可以得到方法返回的结果
	 */
	void afterReturning(Object ori, Object proxy, Method method, Object[] args, Object result);

	/**
	 * 异常通知，可以得到异常信息
	 */
	void afterThrowing(Object ori, Object proxy, Method method, Object[] args, Exception e);

	/**
	 * 最终通知
	 */
	void after(Object ori, Object proxy, Method method, Object[] args);

}
