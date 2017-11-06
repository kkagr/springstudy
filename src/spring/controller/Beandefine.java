package spring.controller;

public class Beandefine {
	String id;
	String clazz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public Beandefine(String id, String clazz) {
		super();
		this.id = id;
		this.clazz = clazz;
	}
	

}
