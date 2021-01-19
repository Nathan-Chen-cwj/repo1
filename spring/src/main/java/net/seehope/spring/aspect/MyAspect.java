package net.seehope.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面: 所有存放切面方法的类 aspect 连接点: 原始对象的原始方法 joinPoint 切点: 所有连接点的集合 pointCut 通知:切面方法
 * advice
 * 
 * 
 * 切面增强不会修改原始代码，类似于插件，
 * 如果觉得原始方法不够强，功能不够，可以使用切面，批量选择，批量修改
 * 
 * 事务回滚切面（事务管理器）
 * 日志切面
 * @author Monty
 *
 */
@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* net.seehope..*.service.impl.*.*(..))")
	public void pointCut() {

	}

	@Before(value = "pointCut()")
	public boolean before(JoinPoint jp) {

		System.out.println("before");
		return true;
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around");
		Object result = pjp.proceed();
		return result;
	}

	@AfterReturning(pointcut = "pointCut()", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		System.out.println("afterReturning");
	}

	@AfterThrowing(throwing = "e", pointcut = "pointCut()")
	public void afterThrowing(JoinPoint jp, Exception e) {
		System.out.println("afterThrowing");
	}

	@After("pointCut()")
	public void after(JoinPoint jp) {
		System.out.println("after");
	}

}
