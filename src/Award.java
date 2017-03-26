import java.util.*;

public class Award {

	public void Awd() {
		// get Index
		Scanner input4 = new Scanner(System.in);
		System.out.print("Enter Index No: ");
		String index = input4.next();
		System.out.println("");

		FileHandling handler = new FileHandling();
		String[] fields = (handler.read(index)).split("#");

		// level 4 point calculation
		String[] l4Marks = (fields[2]).split("/");
		String[] marks4 = new String[2];
		int pointL4 = 0;

		for (int i = 0; i < 6; i++) {
			marks4 = l4Marks[i].split("-");
			// System.out.println(marks4[0]);
			if ((Double.parseDouble(marks4[0])) >= 40.0) {
				pointL4 += 20;
			}
		}
		// System.out.println("get L4 points");

		// level 5 point calculation
		int pointL5 = 0;
		// System.out.println(fields[3]);
		if (fields[3].equalsIgnoreCase("0")) {
			pointL5 = 0;
		} else {
			String[] l5Marks = (fields[3]).split("/");
			String[] marks5 = new String[2];
			// System.out.println("get points");
			for (int i = 0; i < 6; i++) {
				marks5 = l5Marks[i].split("-");
				if (Double.parseDouble(marks5[0]) >= 40) {
					pointL5 += 20;
				}
			}
		}

		// System.out.println("get L5 points");

		// level 5 point calculation
		int pointL6 = 0;
		// System.out.println(fields[3]);
		if (fields[4].equalsIgnoreCase("0")) {
			pointL6 = 0;
		} else {
			String[] l6Marks = (fields[4]).split("/");
			String[] marks6 = new String[2];
			// System.out.println("get points");
			for (int i = 0; i < 4; i++) {
				marks6 = l6Marks[i].split("-");
				if (Double.parseDouble(marks6[0]) >= 40) {
					pointL6 += 20;
				}
			}
			marks6 = l6Marks[4].split("-");
			if (Double.parseDouble(marks6[0]) >= 40) {
				pointL6 += 40;
			}
		}

		double points = pointL4 + pointL5 + pointL6;
		// System.out.println(points);

		// Award calculation
		System.out.println("CONGRATULATIONS!!!!");
		System.out.print("ELIGIBLE FOR: ");
		if ((points) >= 360) {
			// Go to class calculation;
			Class_Calc obj = new Class_Calc();
			obj.calc(index);
		} else if (points >= 300 && points < 360) {
			System.out.println("Non Hounours Degree");
		} else if (points >= 240 && points < 300) {
			System.out.println("Dip HE");
		} else if (points >= 120 && points < 240) {
			System.out.println("Cert HE");
		} else {
			System.out.println("Nothing");
		}
	}
}
