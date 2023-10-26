package firstWeb;

public class Employee {
	private int id;
	private String name;
	private int age;
	private int experience;
	private int seniority;
	private int salary;
	
	public Employee() {}
	
	public Employee(  String name, int age, int experience,int seniority, int salary) {
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.seniority = seniority;
		this.salary = salary;
	}
	
	
	
	public Employee( int id, String name, int age, int experience,int seniority, int salary) {
		this.id = id;
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", experience=" + experience + ", seniority="
				+ seniority + ", salary=" + salary + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeniority() {
		return seniority;
	}
	
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public int getExperience() {
		return experience;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
