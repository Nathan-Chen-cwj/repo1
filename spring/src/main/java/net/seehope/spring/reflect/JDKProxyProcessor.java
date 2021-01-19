package net.seehope.spring.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class JDKProxyProcessor implements InvocationHandler {

	private Object ori;

	private String interceptorName;

	public JDKProxyProcessor(Object ori) {
		this.ori = ori;
	}

	public JDKProxyProcessor(Object ori, String interceptorName) {
		this.ori = ori;
		this.interceptorName = interceptorName;
	}

	/**
	 * 原始对象的每一个方法，都会被该方法的逻辑所取代
	 * 
	 * proxy 代理对象 method 原始对象中的每一个方法 args 调用改方法的时候的原始参数
	 * 
	 * 
	 * try{
	 * 
	 * 方法执行之前 环绕方法 方法执行的时候 环绕方法 方法执行之后 } catch(){ 方法发生异常之后 }finally{
	 * 
	 * 最终 }
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		if (interceptorName == null) {
			try {
				if (args != null) {
					System.out.println("可以判断当前参数是否允许调用该方法");
				}

				result = method.invoke(ori, args);

				System.out.println(new Date() + "  :  " + " 使用了参数" + Arrays.toString(args) + "  调用了 " + method.getName()
						+ "   方法  " + " 并且得到了 " + result + " 结果");

			} catch (Exception e) {
				// 数据回滚
				e.printStackTrace();
			}
		} else {
			Interceptor interceptor = (Interceptor) Class.forName(interceptorName).newInstance();
			try {
				if (interceptor.before(ori, proxy, method, args)) {
					result = interceptor.around(ori, proxy, method, args);
					interceptor.afterReturning(ori, proxy, method, args, result);
				} else {
					throw new RuntimeException("前置通知未通过，发生异常");
				}
			} catch (Exception e) {
				interceptor.afterThrowing(ori, proxy, method, args, e);
			} finally {
				interceptor.after(ori, proxy, method, args);
			}
		}

		return result;
	}

}
