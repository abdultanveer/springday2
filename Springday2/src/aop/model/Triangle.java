package aop.model;

public class Triangle {
	String name;
	
	//public Triangle() {System.out.println("in triangle constructor");}


	public String getName() {
		return name;
	}

	public String setName(String name) {
		this.name = name;
		return "\nreturning--"+name;
	}
	

}
