import java.util.*;

public class L4_Update {

	public void fAttempt() {
		try {
			String[] ICT1 = new String[6];
			String[] ICT2 = new String[6];
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);

			// get index
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Index No: ");
			String index = input.next();
			System.out.println("");

			// taking user marks
			int i;
			// int count =0;
			do {

				for (i = 0; i < 6; i++) {
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
			for (i = 0; i < 6; i++) {
				average[i] = Double.toString(((Integer.parseInt(ICT1[i]) + Integer.parseInt(ICT2[i])) / 2.0));
			}

			// create string to be write
			String markUpdate = average[0] + "-1" + "/" + average[1] + "-1" + "/" + average[2] + "-1" + "/" + average[3]
					+ "-1" + "/" + average[4] + "-1" + "/" + average[5] + "-1";

			int points = 0;
			Double average01 = Double.parseDouble(average[0]);
			Double average02 = Double.parseDouble(average[1]);
			Double average03 = Double.parseDouble(average[2]);
			Double average04 = Double.parseDouble(average[3]);
			Double average05 = Double.parseDouble(average[4]);
			Double average06 = Double.parseDouble(average[5]);

			if (average01 > 39)
				points += 20;
			if (average02 > 39)
				points += 20;
			if (average03 > 39)
				points += 20;
			if (average04 > 39)
				points += 20;
			if (average05 > 39)
				points += 20;
			if (average06 > 39)
				points += 20;

			// read from file and mark update
			FileHandling obj = new FileHandling();
			String[] fields = (obj.read(index)).split("#");
			fields[2] = markUpdate;
			if (points >= 100) {
				fields[1] = "Level 5";
				// System.out.println("Get Passed 04");
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

	public void condoned() {
		try {
			// get Index
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter Index No:");
			String index = input2.next();

			// choose module
			System.out.println("Select the Condoned Module:");
			System.out.println("1-Module 01");
			System.out.println("2-Module 02");
			System.out.println("3-Module 03");
			System.out.println("4-Module 04");
			System.out.println("5-Module 05");
			System.out.println("6-Module 06");

			System.out.println("");
			System.out.print("Enter First Condoned Module: ");
			String con1 = input2.next();
			System.out.println("If there No second Condoned Module, Please Enter '0' ");
			System.out.print("Enter Second Condoned Module: ");
			String con2 = input2.next();

			FileHandling obj = new FileHandling();
			String[] fields = (obj.read(index)).split("#");

			String[] currentMarks = (fields[2]).split("/");
			System.out.println("");
			switch (Integer.parseInt(con1)) {
			case 1:
				currentMarks[0] = "40-1";
				break;
			case 2:
				currentMarks[1] = "40-1";
				break;
			case 3:
				currentMarks[2] = "40-1";
				break;
			case 4:
				currentMarks[3] = "40-1";
				break;
			case 5:
				currentMarks[4] = "40-1";
				break;
			case 6:
				currentMarks[5] = "40-1";
				break;
			default:
				System.out.println("Invalid Module Selection");
				break;
			}

			switch (Integer.parseInt(con2)) {
			case 1:
				currentMarks[0] = "40-1";
				break;
			case 2:
				currentMarks[1] = "40-1";
				break;
			case 3:
				currentMarks[2] = "40-1";
				break;
			case 4:
				currentMarks[3] = "40-1";
				break;
			case 5:
				currentMarks[4] = "40-1";
				break;
			case 6:
				currentMarks[5] = "40-1";
				break;
			default:
				break;
			}

			// make the string to be written
			String newMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3]
					+ "/" + currentMarks[4] + "/" + currentMarks[5];

			int points = 0;
			String[] Marks = new String[2];
			// calculate points
			for (int i = 0; i < 6; i++) {
				Marks = currentMarks[i].split("-");
				if (Double.parseDouble(Marks[0]) >= 40) {
					points += 20;
				}
			}
			fields[2] = newMarks;
			if (points >= 100) {
				fields[1] = "Level 5";
				// System.out.println("Get Passed 04");
			}
			// System.out.println(newMarks);

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

	public void referral() {
		try {
			// get Index No
			Scanner input3 = new Scanner(System.in);
			System.out.print("Enter Index No:");
			String index = input3.next();
			System.out.println("");
			// choose Module
			System.out.println("***************");
			System.out.println("1-Module 01");
			System.out.println("2-Module 02");
			System.out.println("3-Module 03");
			System.out.println("4-Module 04");
			System.out.println("5-Module 05");
			System.out.println("6-Module 06");

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

			String[] currentMarks = (fields[2]).split("/");
			String[] modData = new String[2];

			switch (Integer.parseInt(refMod)) {
			case 1:
				modData = currentMarks[0].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[0] = modData[0] + "-" + modData[1];
				break;
			case 2:
				modData = currentMarks[1].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[1] = modData[0] + "-" + modData[1];
				break;
			case 3:
				modData = currentMarks[2].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[2] = modData[0] + "-" + modData[1];
				break;
			case 4:
				modData = currentMarks[3].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[3] = modData[0] + "-" + modData[1];
				break;
			case 5:
				modData = currentMarks[4].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[4] = modData[0] + "-" + modData[1];
				break;
			case 6:
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

			String newMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3]
					+ "/" + currentMarks[4] + "/" + currentMarks[5];

			String[] Marks = new String[2];
			int points = 0;

			for (int i = 0; i < 6; i++) {
				Marks = currentMarks[i].split("-");
				if (Double.parseDouble(Marks[0]) >= 40) {
					points += 20;
				}
			}

			fields[2] = newMarks;
			if (points >= 100) {
				fields[1] = "Level 5";
				// System.out.println("Get passed 04");
			}
			try {
				FileHandling handler = new FileHandling();
				// System.out.println(fields[0]+"#"+fields[1]+"#"+fields[2]+"#"+fields[3]+"#"+fields[4]);
				handler.write(index, fields[0] + "#" + fields[1] + "#" + fields[2] + "#" + fields[3] + "#" + fields[4]);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			System.out.println("please eneter marks only with digits");
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
			System.out.println("1-Module 01");
			System.out.println("2-Module 02");
			System.out.println("3-Module 03");
			System.out.println("4-Module 04");
			System.out.println("5-Module 05");
			System.out.println("6-Module 06");

			System.out.print("Select the Retake Module: ");
			String refMod = input3.next();

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

			String[] currentMarks = (fields[2]).split("/");
			String[] modData = new String[2];

			switch (Integer.parseInt(refMod)) {
			case 1:
				modData = currentMarks[0].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[0] = modData[0] + "-" + modData[1];
				break;
			case 2:
				modData = currentMarks[1].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[1] = modData[0] + "-" + modData[1];
				break;
			case 3:
				modData = currentMarks[2].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[2] = modData[0] + "-" + modData[1];
				break;
			case 4:
				modData = currentMarks[3].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[3] = modData[0] + "-" + modData[1];
				break;
			case 5:
				modData = currentMarks[4].split("-");
				modData[0] = marks;
				if (Integer.parseInt(modData[1]) < 4) {
					modData[1] = Integer.toString(Integer.parseInt(modData[1]) + 1);
				} else
					System.out.println("THE STUDENT HAS BEEN EXCLUDED");
				currentMarks[4] = modData[0] + "-" + modData[1];
				break;
			case 6:
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

			String newMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3]
					+ "/" + currentMarks[4] + "/" + currentMarks[5];

			String[] Marks = new String[2];
			int points = 0;

			for (int i = 0; i < 6; i++) {
				Marks = currentMarks[i].split("-");
				if (Double.parseDouble(Marks[0]) >= 40) {
					points += 20;
				}
			}

			fields[2] = newMarks;
			if (points >= 100) {
				fields[1] = "Level 5";
				// System.out.println("Get passed 04");
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
