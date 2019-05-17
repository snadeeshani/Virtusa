
public class Staff {
	
	//Level 02--> Using Inner Class
	class Teacher{
		
		public void teach(){
			System.out.println("Teachers teach Java");
		}
	}
	
	//Level 03--> Using Member Class

	public void manage()
	{
		class Principal
		{
			public void control()
			{
				System.out.println("Principal is Mr.Kumar Rathnayake");
			}
		}
		Principal principal=new Principal();
		principal.control();
	}

}
