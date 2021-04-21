package aop.main;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
	@Before("execution(* aop..*.get*())")
		public void loggingAdvice() {
		System.out.println("writing log before method is executed");
	}

}
