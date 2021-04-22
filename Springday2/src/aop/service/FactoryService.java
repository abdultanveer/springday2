package aop.service;

import aop.model.Circle;
import aop.model.Triangle;

public class FactoryService {
	public Object getBean(String beanType) {
		if(beanType.equals("shapeService")) return new ShapeServiceProxy(); //3. ShapeService();
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Triangle();
		else 	return null;
	}

}
