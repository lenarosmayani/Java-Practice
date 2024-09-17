
//Membuat child class Teacher dengan perintah "extends"
public class Teacher extends Person {
	String subject;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, String address, String subject) {
		super(name,address);
		this.subject = subject;
	}
	void teaching() {
		System.out.println("I can teach" + subject + ", So anyone how wants to learn can talk to me");
	}
	
	void greeting() {
		System.out.println("Hello my name is " + name + ".");
		System.out.println("I come from " + address + ".");
		System.out.println("My job is a " + subject + " teacher.");
	}
}
