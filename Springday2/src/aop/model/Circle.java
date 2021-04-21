package aop.model;

public class Circle {
	String name;

	public Circle() {System.out.println("in circle constructor");}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setting name for the circle");
		this.name = name;
		
	}
	
	public int getDia() {
		return 5;
	}
	
	

}
