import java.util.Scanner;

public class L6_Update {
	public void fAttempt() {
		try {
			String[] ICT1 = new String[5];
			String[] ICT2 = new String[5];
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);

			// get index
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Index No: ");
			String index = input.next();
			System.out.println("");
			do {
				// taking user marks
				for (int i = 0; i < 5; i++) {
					System.out.print("Enter Module " + Integer.toString(i + 1) + " Marks Part1 : ");
					ICT1[i] = sc1.nextLine();
					System.out.print("Enter Module " + Integer.toString(i + 1) + " Marks Part2 : ");
					ICT2[i] = sc2.nextLine();
				}
			} while (!(Double.parseDouble(ICT1[0]) >= 0 && Double.parseDouble(ICT2[0]) <= 100
					&& Double.parseDouble(ICT1[1]) >= 0 && Double.parseDouble(ICT2[1]) <= 100
					&& Double.parseDouble(ICT1[2]) >= 0 && Double.parseDouble(ICT2[2]) <= 100
					&& Double.parseDouble(ICT1[3]) >= 0 && Double.parseDouble(ICT2[3]) <= 100
					&& Double.parseDouble(ICT1[4]) >= 0 && Double.parseDouble(ICT2[4]) <= 100));

			System.out.println("");
			System.out.println("Finished Marks Input***");
			// calculating averages
			String[] average = new String[5];
			for (int i = 0; i < 5; i++) {
				average[i] = Double.toString(((Integer.parseInt(ICT1[i]) + Integer.parseInt(ICT2[i])) / 2.0));
			}

			// create string to be write
			String markUpdate = average[0] + "-1" + "/" + average[1] + "-1" + "/" + average[2] + "-1" + "/" + average[3]
					+ "-1" + "/" + average[4] + "-1";

			int points = 0;
			Double average13 = Double.parseDouble(average[0]);
			Double average14 = Double.parseDouble(average[1]);
			Double average15 = Double.parseDouble(average[2]);
			Double average16 = Double.parseDouble(average[3]);
			Double average17 = Double.parseDouble(average[4]);

			if (average13 > 39)
				points += 20;
			if (average14 > 39)
				points += 20;
			if (average15 > 39)
				points += 20;
			if (average16 > 39)
				points += 20;
			if (average17 > 39)
				points += 40;

			// read from file and mark update
			FileHandling obj = new FileHandling();
			String[] fields = (obj.read(index)).split("#");
			fields[4] = markUpdate;
			if (points >= 100) {
				fields[1] = "Gratuated";
				// System.out.println("Get Passed 06");
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
		try {
			// get Index No
			Scanner input3 = new Scanner(System.in);
			System.out.print("Enter Index No:");
			String index = input3.next();
			System.out.println("");
			// choose Module
			System.out.println("***************");
			System.out.println("13 -Module 13");
			System.out.println("14 -Module 14");
			System.out.println("15 -Module 15");
			System.out.println("16 -Module 16");
			System.out.println("17 -Module 17");

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

			String[] currentMarks = (fields[4]).split("/");
			String[] modData = new String[2];

			switch (Integer.parseInt(refMod)) {
			case 13:
				modData = currentMarks[0].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[0] = modData[0] + "-" + modData[1];
				break;
			case 14:
				modData = currentMarks[1].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[1] = modData[0] + "-" + modData[1];
				break;
			case 15:
				modData = currentMarks[2].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[2] = modData[0] + "-" + modData[1];
				break;
			case 16:
				modData = currentMarks[3].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[3] = modData[0] + "-" + modData[1];
				break;
			case 17:
				modData = currentMarks[4].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[4] = modData[0] + "-" + modData[1];
				break;
			default:
				System.out.println("Invalid Module Selection");
				break;
			}

			String newMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3]
					+ "/" + currentMarks[4];

			String[] Marks = new String[2];
			int points = 0;

			for (int i = 0; i < 5; i++) {
				Marks = currentMarks[i].split("-");
				if (Double.parseDouble(Marks[0]) >= 40) {
					points += 20;
				}
			}

			fields[4] = newMarks;
			if (points >= 100) {
				fields[1] = "Gratuated";
				// System.out.println("Get passed 06");
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
		try {
			// get Index No
			Scanner input3 = new Scanner(System.in);
			System.out.print("Enter Index No: ");
			String index = input3.next();
			System.out.println("");
			// choose Module
			System.out.println("***************");
			System.out.println("13 -Module 13");
			System.out.println("14 -Module 14");
			System.out.println("15 -Module 15");
			System.out.println("16 -Module 16");
			System.out.println("17 -Module 17");

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

			String[] currentMarks = (fields[4]).split("/");
			String[] modData = new String[2];

			switch (Integer.parseInt(refMod)) {
			case 13:
				modData = currentMarks[0].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[0] = modData[0] + "-" + modData[1];
				break;
			case 14:
				modData = currentMarks[1].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[1] = modData[0] + "-" + modData[1];
				break;
			case 15:
				modData = currentMarks[2].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[2] = modData[0] + "-" + modData[1];
				break;
			case 16:
				modData = currentMarks[3].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[3] = modData[0] + "-" + modData[1];
				break;
			case 17:
				modData = currentMarks[4].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[4] = modData[0] + "-" + modData[1];
				break;
			default:
				System.out.println("Invalid Module Selection");
				break;
			}

			String newMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3]
					+ "/" + currentMarks[4];

			String[] Marks = new String[2];
			int points = 0;

			for (int i = 0; i < 5; i++) {
				Marks = currentMarks[i].split("-");
				if (Double.parseDouble(Marks[0]) >= 40) {
					points += 20;
				}
			}

			fields[4] = newMarks;
			if (points >= 100) {
				fields[1] = "Gratuated";
				// System.out.println("Get passed 06");
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
