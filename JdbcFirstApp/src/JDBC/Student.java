package JDBC;

public class Student {
	int id;
	String name;
	String sub;
	public Student(int id, String name, String sub) {
		super();
		this.id = id;
		this.name = name;
		this.sub = sub;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", sub=" + sub + "]";
	}
	public Student() {
		
	}
}
