
public class Application {
	public static void main(String[] args) {
		
		// Level 01--> Using Private variables ,Getters and Setters 
		Student student=new Student();
		student.setId(1);
		student.setName("Nadeeshani");
		student.setCourse("Java");
		
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		
		System.out.println("-------------------------");
	
		
		//Level 02--> Using Inner Class
		Staff staff=new Staff();
		Staff.Teacher teacher=staff.new Teacher();
		teacher.teach();
		
		System.out.println("-------------------------");
		
		//Level 03--> Using Member Class
		Staff stf=new Staff();
		stf.manage();
		
		System.out.println("-------------------------");
		
		
		//Level 04--> Using Anonymous Class
		Salary salary=new Salary()
				{
					public void pay()
					{
						System.out.println("Monthly Salary for a Principal :Rs. 50,000.00");
					}
				};
				
		salary.pay();	
	}

}
