package aop.main;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
	
	@Before("allCircleMethods()")
	public void loggingAdvice() {
		System.out.println("writing log before method is executed");
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
	
	@Pointcut("execution(* aop..*.get*())")
	public void allGetters() {}
	
	@Pointcut("within(aop.model.Circle)")
	public void allCircleMethods() {}
	
	



}
