package aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import aop.model.Circle;

@Aspect
public class LoggingAspect {
	//one aspect can contain multiple advices

	//@Before("execution(* aop.model..*.*(..))")   --- for all methods of all classes present in this package and its subpackages

	//@Before("execution(public String aop.model.Triangle.getName())")
	//@Before("execution(* aop..*.*(..))")  --for aop and its subpackages

	//@Before("execution(* aop..*.*(..))")

	//@Before("execution(public String aop.model.*.getName())")  --- for all getName methods in all classes within the package aop.model
	//@Before("execution(public * aop.model.*.getName())")  --- irrespective of return type
	//@Before("execution(public * aop.model.*.get*())")   --- for all methods which start with get


	//@Before("execution(* aop..*.get*())")  == 	@Before("allGetters()")


	/*
	 * @Before("allCircleMethods()") public void loggingAdvice(JoinPoint joinPoint)
	 * { String methodName = joinPoint.toLongString();
	 * 
	 * if(methodName.contains("getDia")) { Circle circle = (Circle)
	 * joinPoint.getTarget(); System.out.println(circle.getName());
	 * System.out.println("writing log for getdia method b4 its executed");
	 * 
	 * } else if(methodName.contains("setName")) {
	 * System.out.println("writing log for setName method b4 its executed");
	 * 
	 * 
	 * } }
	 */

	/*
	 * @AfterReturning("allGetters()") public void
	 * adviceAfterCircleMethodsComplete() {
	 * System.out.println("after a circle method returns"); }
	 * 
	 * 
	 * @AfterThrowing("args(name)") public void adviceAfterExceptionThrown(String
	 * name) { //send an email to the developer if an exception is thrown
	 * System.out.println("advice after exception is thrown"+name); }
	 * 
	 * //@AfterReturning(pointcut = "arg(name)" ,returning = "opString" )
	 * 
	 * @AfterReturning(pointcut="args(name)", returning="returnString")
	 * 
	 * public void StringArgsMethods(String name,String returnString) {
	 * System.out.println("i/p String ="+name +"\n o/p String="+returnString); }
	 */

	@Pointcut("execution(* aop..*.get*())")
	public void allGetters() {}

	@Pointcut("within(aop.model.Circle)")
	public void allCircleMethods() {}

	//@Before("args(name)")
	/*
	 * @Before("methodsStringArgs(name)") public void stringArgsAdvice(String name)
	 * { System.out.
	 * println("advice for all methods which accept a string as an argument "+name);
	 * }
	 */

	@Pointcut("args(name)")
	public void methodsStringArgs(String name) {}
	
	@Around("@annotation(aop.aspects.Loggable)") //i want myArou
	public void myAroundAdvice(ProceedingJoinPoint pjp) {
		
		try {
			System.out.println("before advice");
			pjp.proceed();
			System.out.println("after method returns advice");

		} catch (Throwable e) {
			System.out.println("after throwing");
			//e.printStackTrace();
		} System.out.println("finally advice");
		
	}
	


	/*
	 * @Before("execution(* aop..*.get*())") public void secondAdviceforAllGetters()
	 * { System.out.println("second log before method is executed"); }
	 * 
	 * //@Before("execution(* aop..*.get*())")
	 * 
	 * @Before("allGetters") public void thirdAdviceforAllGetters() {
	 * System.out.println("third log before method is executed"); }
	 */



}
