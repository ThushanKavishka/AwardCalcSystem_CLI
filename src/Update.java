import java.util.*;

public class Update {

	public void Upd() {

		System.out.println("4-Level 04");
		System.out.println("5-Level 05");
		System.out.println("6-Level 06");

		Scanner scr = new Scanner(System.in);
		System.out.print("Enter Level:  ");
		String getLevel = scr.next();
		System.out.println("");

		boolean done = true;
		int Attempt = 0;
		while (done) {

			System.out.println("1-fAttempt");
			System.out.println("2-Condoned");
			System.out.println("3-Refferal");
			System.out.println("4-Retake");

			System.out.print("Select Your Attempt: ");

			Attempt = scr.nextInt();
			System.out.println("");
			if (Attempt < 5 && Attempt > 0) {
				done = false;
			}
		}

		if (getLevel.equalsIgnoreCase("4")) {
			L4_Update obj = new L4_Update();
			switch (Attempt) {
			case 1:
				System.out.println("------Level4 Marks------");
				obj.fAttempt();
				break;

			case 2:
				System.out.println("------Level4 Condoned Marks------");
				obj.condoned();
				break;

			case 3:
				System.out.println("------Level4 Referral Marks------");
				obj.referral();
				break;

			case 4:
				System.out.println("------Level4 Retake Marks------");
				obj.retake();
				break;

			default:
				System.out.println("INVALID SELECTION");
			}
		} else if (getLevel.equalsIgnoreCase("5")) {
			L5_Update obj2 = new L5_Update();
			switch (Attempt) {
			case 1:
				System.out.println("------Level5 Marks------");
				obj2.fAttempt();
				break;

			case 2:
				System.out.println("Condoned Not Valid For L5");
				break;

			case 3:
				System.out.println("------Level5 Referral Marks------");
				obj2.referral();
				break;

			case 4:
				System.out.println("------Level5 Retake Marks------");
				obj2.retake();
				break;

			default:
				System.out.println("INVALID SELECTION");
			}
		}
		if (getLevel.equalsIgnoreCase("6")) {
			L6_Update obj3 = new L6_Update();
			switch (Attempt) {
			case 1:
				System.out.println("------Level6 Marks------");
				obj3.fAttempt();
				break;

			case 2:
				System.out.println("Condoned Not Valid For L6");
				break;
			case 3:
				System.out.println("------Level6 Referral Marks------");
				obj3.referral();
				break;

			case 4:
				System.out.println("------Level6 Retake Marks------");
				obj3.retake();
				break;

			default:
				System.out.println("INVALID SELECTION");
			}
		}

	}
}
