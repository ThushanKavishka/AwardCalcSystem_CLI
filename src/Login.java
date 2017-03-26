import java.util.*;

public class Login {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("                        ***WELCOME TO AWARD CALCULATION SYSTEM***              ");
		System.out.println("        LOGIN ##    ");
		System.out.println("");
		System.out.print("   USERNAME:   ");
		String username = sc.next();
		System.out.print("   PASSWORD:   ");
		String password = sc.next();
		System.out.println("");
		if ((username.equalsIgnoreCase("Gugsi")) && ((password.equalsIgnoreCase("Devil")))) {
			System.out.println("Login Successfully!!!");

			FileHandling handler = new FileHandling();
			handler.listCreate("Stud_List");

			while (true) {
				System.out.println("");
				System.out.println("---------------HOME PAGE---------------");
				boolean done = true;
				int var = 0;
				while (done) {

					System.out.println("1-Registration");
					System.out.println("2-Update");
					System.out.println("3-Check Info");
					System.out.println("4-Award");
					System.out.print("Select Your Route:  ");
					var = sc.nextInt();
					if (var < 5 && var > 0) {
						done = false;
					}
				}
				switch (var) {
				case 1:
					System.out.println("");
					System.out.println("----------REGISTRATION----------");
					Registration obj1 = new Registration();
					obj1.Regis();
					// done = false;
					break;
				case 2:
					System.out.println("");
					System.out.println("----------UPDATE----------");
					Update obj2 = new Update();
					obj2.Upd();
					// done = false;
					break;
				case 3:
					System.out.println("");
					System.out.println("----------CHECK INFO----------");
					Info obj3 = new Info();
					obj3.selectReport();
					break;
				case 4:
					System.out.println("");
					System.out.println("----------AWARD----------");
					Award obj4 = new Award();
					obj4.Awd();
					// done = false;
					break;
				default:
					System.out.println("");
					System.out.println("INVALID SELECTION");
					break;
				}
			}
		} else {
			System.out.println("Username or Password Incorrect");
		}
	}
}
