import java.util.Scanner;

public class L5_Update {
	public void fAttempt() {
		try{
			String[] ICT1 = new String[6];
			String[] ICT2 = new String[6];
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			
			// get index
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Index No: ");
			String index = input.next();
			System.out.println("");
			do {
				// taking user marks
				for (int i = 0; i < 6; i++) {
					System.out.print("Enter Module " + Integer.toString(i + 1) + " Marks Part1 : ");
					ICT1[i] = sc1.nextLine();
					System.out.print("Enter Module " + Integer.toString(i + 1) + " Marks Part2 : ");
					ICT2[i] = sc2.nextLine();
				}
			} while (!(Double.parseDouble(ICT1[0]) >= 0 && Double.parseDouble(ICT2[0]) <= 100
					&& Double.parseDouble(ICT1[1]) >= 0 && Double.parseDouble(ICT2[1]) <= 100
					&& Double.parseDouble(ICT1[2]) >= 0 && Double.parseDouble(ICT2[2]) <= 100
					&& Double.parseDouble(ICT1[3]) >= 0 && Double.parseDouble(ICT2[3]) <= 100
					&& Double.parseDouble(ICT1[4]) >= 0 && Double.parseDouble(ICT2[4]) <= 100
					&& Double.parseDouble(ICT1[5]) >= 0 && Double.parseDouble(ICT2[5]) <= 100));

			System.out.println("");
			System.out.println("Finished Marks Input***");
			// calculating averages
			String[] average = new String[6];
			for (int i = 0; i < 6; i++) {
				average[i] = Double.toString(((Integer.parseInt(ICT1[i]) + Integer.parseInt(ICT2[i])) / 2.0));
			}

			// create string to be write
			String markUpdate = average[0] + "-1" + "/" + average[1] + "-1" + "/" + average[2] + "-1" + "/" + average[3]
					+ "-1" + "/" + average[4] + "-1" + "/" + average[5] + "-1";

			int points = 0;
			Double average07 = Double.parseDouble(average[0]);
			Double average08 = Double.parseDouble(average[1]);
			Double average09 = Double.parseDouble(average[2]);
			Double average10 = Double.parseDouble(average[3]);
			Double average11 = Double.parseDouble(average[4]);
			Double average12 = Double.parseDouble(average[5]);

			if (average07 > 39)
				points += 20;
			if (average08 > 39)
				points += 20;
			if (average09 > 39)
				points += 20;
			if (average10 > 39)
				points += 20;
			if (average11 > 39)
				points += 20;
			if (average12 > 39)
				points += 20;

			// read from file and mark update
			FileHandling obj = new FileHandling();
			String[] fields = (obj.read(index)).split("#");
			fields[3] = markUpdate;
			if (points >= 100) {
				fields[1] = "Level 6";
				// System.out.println("Get Passed 05");
			}
			try {
				FileHandling handler = new FileHandling();
				handler.write(index, fields[0] + "#" + fields[1] + "#" + fields[2] + "#" + fields[3] + "#" + fields[4]);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			System.out.println("please enter marks only with digits");
		}
	}

	public void referral() {
		try{
		// get Index No
		Scanner input3 = new Scanner(System.in);
		System.out.print("Enter Index No:");
		String index = input3.next();
		System.out.println("");
		// choose Module
		System.out.println("***************");
		System.out.println("7 -Module 07");
		System.out.println("8 -Module 08");
		System.out.println("9 -Module 09");
		System.out.println("10-Module 10");
		System.out.println("11-Module 11");
		System.out.println("12-Module 12");

		System.out.print("Select the Refferal Module: ");
		String refMod = input3.next();
		System.out.println("");
		boolean done = true;
		String marks = "";
		while (done) {
			System.out.print("Enter Module Marks:  ");
			marks = input3.next();
			if (Integer.parseInt(marks) < 41 && Integer.parseInt(marks) >= 0) {
				done = false;
			}
		}

		FileHandling obj = new FileHandling();
		String[] fields = (obj.read(index)).split("#");

		String[] currentMarks = (fields[3]).split("/");
		String[] modData = new String[2];

		switch (Integer.parseInt(refMod)) {
		case 7:
			modData = currentMarks[0].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[0] = modData[0] + "-" + modData[1];
			break;
		case 8:
			modData = currentMarks[1].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[1] = modData[0] + "-" + modData[1];
			break;
		case 9:
			modData = currentMarks[2].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[2] = modData[0] + "-" + modData[1];
			break;
		case 10:
			modData = currentMarks[3].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[3] = modData[0] + "-" + modData[1];
			break;
		case 11:
			modData = currentMarks[4].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[4] = modData[0] + "-" + modData[1];
			break;
		case 12:
			modData = currentMarks[5].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[5] = modData[0] + "-" + modData[1];
			break;
		default:
			System.out.println("Invalid Module Selection");
			break;
		}

		String newMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
				+ currentMarks[4] + "/" + currentMarks[5];

		String[] Marks = new String[2];
		int points = 0;

		for (int i = 0; i < 6; i++) {
			Marks = currentMarks[i].split("-");
			if (Double.parseDouble(Marks[0]) >= 40) {
				points += 20;
			}
		}

		fields[3] = newMarks;
		if (points >= 100) {
			fields[1] = "Level 6";
			// System.out.println("Get passed 05");
		}
		try {
			FileHandling handler = new FileHandling();
			// System.out.println(fields[0]+"#"+fields[1]+"#"+fields[2]+"#"+fields[3]+"#"+fields[4]);
			handler.write(index, fields[0] + "#" + fields[1] + "#" + fields[2] + "#" + fields[3] + "#" + fields[4]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		} catch (Exception ex) {
			System.out.println("please enter marks only with digits");
		}

	}

	public void retake() {
		try{
		// get Index No
		Scanner input3 = new Scanner(System.in);
		System.out.print("Enter Index No: ");
		String index = input3.next();
		System.out.println("");
		// choose Module
		System.out.println("***************");
		System.out.println("7 -Module 07");
		System.out.println("8 -Module 08");
		System.out.println("9 -Module 09");
		System.out.println("10-Module 10");
		System.out.println("11-Module 11");
		System.out.println("12-Module 12");

		System.out.print("Select the Retake Module: ");
		String refMod = input3.next();
		System.out.println("");
		boolean done = true;
		String marks = "";
		while (done) {
			System.out.print("Enter Module Marks:  ");
			marks = input3.next();
			if (Integer.parseInt(marks) < 41 && Integer.parseInt(marks) >= 0) {
				done = false;
			}
		}

		FileHandling obj = new FileHandling();
		String[] fields = (obj.read(index)).split("#");

		String[] currentMarks = (fields[3]).split("/");
		String[] modData = new String[2];

		switch (Integer.parseInt(refMod)) {
		case 7:
			modData = currentMarks[0].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[0] = modData[0] + "-" + modData[1];
			break;
		case 8:
			modData = currentMarks[1].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[1] = modData[0] + "-" + modData[1];
			break;
		case 9:
			modData = currentMarks[2].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[2] = modData[0] + "-" + modData[1];
			break;
		case 10:
			modData = currentMarks[3].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[3] = modData[0] + "-" + modData[1];
			break;
		case 11:
			modData = currentMarks[4].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[4] = modData[0] + "-" + modData[1];
			break;
		case 12:
			modData = currentMarks[5].split("-");
			modData[0] = marks;
			if (Integer.parseInt(modData[1]) < 4) {
				modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
			} else
				System.out.println("THE STUDENT HAS BEEN EXCLUDED");
			currentMarks[5] = modData[0] + "-" + modData[1];
			break;
		default:
			System.out.println("Invalid Module Selection");
			break;
		}

		String newMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
				+ currentMarks[4] + "/" + currentMarks[5];

		String[] Marks = new String[2];
		int points = 0;

		for (int i = 0; i < 6; i++) {
			Marks = currentMarks[i].split("-");
			if (Double.parseDouble(Marks[0]) >= 40) {
				points += 20;
			}
		}

		fields[3] = newMarks;
		if (points >= 100) {
			fields[1] = "Level 6";
			// System.out.println("Get passed 05");
		}
		try {
			FileHandling handler = new FileHandling();
			// System.out.println(fields[0]+"#"+fields[1]+"#"+fields[2]+"#"+fields[3]+"#"+fields[4]);
			handler.write(index, fields[0] + "#" + fields[1] + "#" + fields[2] + "#" + fields[3] + "#" + fields[4]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		} catch (Exception ex) {
			System.out.println("please enter marks only with digits");
		}

	}

}
