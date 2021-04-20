package aop.xml;
import java.lang.reflect.Method;  
import org.springframework.aop.MethodBeforeAdvice;  
public class BeforeAdvisor implements MethodBeforeAdvice{  
	@Override  
	public void before(Method method, Object[] args, Object target)throws Throwable {  
		System.out.println("additional concern  to log before actual logic");  
	}  
}  