package basics.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//System.out.println("hello world");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		/*
		 * Tyre tyre = (Tyre) context.getBean("tyre"); System.out.println(tyre);
		 */
				//new Tyre();
		
		 Vehicle vehicle = (Vehicle) context.getBean("car"); 
		 vehicle.drive();
		 
	}

}
