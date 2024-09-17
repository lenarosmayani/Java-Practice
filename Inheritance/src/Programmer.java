
//Membuat child class programmer dengan perintah "extends"
public class Programmer extends Person {
	String technology;
	
	public Programmer() {
		super();
	}
	
	public Programmer(String name, String address, String technology) {
		super(name, address);
		this.technology = technology;
	}

	void hacking() {
		System.out.println("I can hacking a website");
	}
	
	void coding() {
		System.out.println("I can create an application using technology : " + technology + ".");
	}
	
	void greeting() {
		super.greeting();// Memanggil method greeting dari parent atau person class
		System.out.println("My job is a " + technology + " programmer.");
	}
}
