import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Info {

	public void selectReport() {

		boolean done2 = true;
		int repType = 0;
		while (done2) {
			System.out.println("1 -Student Report");
			System.out.println("2 -Module Report");
			System.out.println("3 -Exclusion Report");

			System.out.print("Select the report you need: ");
			Scanner sc = new Scanner(System.in);
			repType = sc.nextInt();
			System.out.println("");
			if (repType < 4 && repType > 0) {
				done2 = false;
			}
		}

		switch (repType) {
		case 1:
			studentInfo();
			break;
		case 2:
			moduleInfo();
			;
			break;
		case 3:
			exclusionInfo();
			break;
		}
	}

	// Info of a module
	public void moduleInfo() {
		int pass = 0;
		int refferal = 0;
		int retake = 0;

		boolean done3 = true;
		int level = 0;
		while (done3) {

			System.out.println("4 -Level 04");
			System.out.println("5 -Level 05");
			System.out.println("6 -Level 06");

			System.out.print("Insert Level: ");
			Scanner sc = new Scanner(System.in);
			level = Integer.parseInt(sc.next());
			System.out.println("");
			if (level > 3 && level < 7) {
				done3 = false;
			}
		}

		switch (level) {
		case 4:
			System.out.println("1 -Module 01");
			System.out.println("2 -Module 02");
			System.out.println("3 -Module 03");
			System.out.println("4 -Module 04");
			System.out.println("5 -Module 05");
			System.out.println("6 -Module 06");
			break;
		case 5:
			System.out.println("1  -Module 07");
			System.out.println("2  -Module 08");
			System.out.println("3  -Module 09");
			System.out.println("4  -Module 10");
			System.out.println("5  -Module 11");
			System.out.println("6  -Module 12");
			break;
		case 6:
			System.out.println("1 -Module 13");
			System.out.println("2 -Module 14");
			System.out.println("3 -Module 15");
			System.out.println("4 -Module 16");
			System.out.println("5 -Module 17");
			break;
		default:
			System.out.println("INVALID SELECTION");
			break;

		}

		System.out.print("Insert Module: ");
		Scanner sc1 = new Scanner(System.in);
		int module = Integer.parseInt(sc1.next());
		System.out.println("");

		FileHandling obj1 = new FileHandling();
		String Students = obj1.read("Stud_List");

		String[] StudentList = Students.split("/");
		System.out.println(Arrays.toString(StudentList));

		int i = 0;
		// int length=0;
		// checking through all the students in the list
		while (i < StudentList.length) {
			// take a student for the relevant index and split field
			String[] dataField = (obj1.read(StudentList[i])).split("#");

			if (!(dataField[level - 2].equalsIgnoreCase("0"))) {
				// get the level marks of relevant level, from fields
				String[] levelMarks = dataField[level - 2].split("/");
				// get the exact module details from level marks
				String[] modData = levelMarks[module - 1].split("-");

				if (Double.parseDouble(modData[0]) >= 40.0 && Double.parseDouble(modData[1]) == 1) {
					pass++;
				}
				if (Double.parseDouble(modData[1]) == 2) {
					refferal++;
				}
				if (Double.parseDouble(modData[1]) == 3) {
					retake++;
				}
				if (Double.parseDouble(modData[1]) == 4) {
					refferal++;
				}
			}
			i++;
			// length++;
		}
		System.out.println("Level " + level + " Module " + module);
		System.out.println("Number of Passes  =" + pass);
		System.out.println("Number of Resits  =" + refferal);
		System.out.println("Number of Retakes =" + retake);
	}

	// Info of exclusion
	public void exclusionInfo() {

		String[] excludeIndex = new String[100];
		for (int counter = 0; counter < excludeIndex.length; counter++) {
			excludeIndex[counter] = "@";
		}

		FileHandling obj1 = new FileHandling();
		String Students = obj1.read("Stud_List");

		String[] StudentList = Students.split("/");

		int i = 0;
		int k = 0;

		// checking through all the students in the list
		while (i < StudentList.length) {
			boolean excluded = false;
			// take a student and split field
			String[] dataField = (obj1.read(StudentList[i])).split("#");

			// check level4
			if (!(dataField[2].equalsIgnoreCase("0"))) {
				// get the level marks of relevant level, from fields
				String[] level4Marks = dataField[2].split("/");
				// System.out.println("checkl4 marks");
				int j1 = 0;
				// System.out.println(level4Marks.length);
				while (j1 < level4Marks.length) {
					// get module data
					String[] mod4Data = level4Marks[j1].split("-");
					if (Double.parseDouble(mod4Data[0]) < 40 && Double.parseDouble(mod4Data[1]) == 4) {
						excluded = true;
						break;
					}
					j1++;
				}
			}

			// check level5
			if (!(dataField[3].equalsIgnoreCase("0"))) {
				// get the level marks of relevant level, from fields
				String[] level5Marks = dataField[3].split("/");
				// System.out.println("checkl5 marks");
				int j2 = 0;
				while (j2 < level5Marks.length) {
					// get module data
					String[] mod5Data = level5Marks[j2].split("-");
					if (Double.parseDouble(mod5Data[0]) < 40 && Double.parseDouble(mod5Data[1]) == 4) {
						excluded = true;
						break;
					}
					j2++;
				}
			}

			// check level6
			if (!(dataField[4].equalsIgnoreCase("0"))) {
				// get the level marks of relevant level, from fields
				String[] level6Marks = dataField[4].split("/");

				int j3 = 0;
				while (j3 < level6Marks.length) {
					// get module data
					String[] mod6Data = level6Marks[j3].split("-");

					if (Double.parseDouble(mod6Data[0]) < 40 && Double.parseDouble(mod6Data[1]) == 4) {
						excluded = true;
						break;
					}
					j3++;
				}
			}
			// if excluded at any level this will be true
			if (excluded) {
				// get the excluded index and store it in another array
				excludeIndex[k] = dataField[0];
				k++;
			}
			i++;
		}

		// printing excluded indexes
		System.out.print("Excluded Students Are: ");
		int count = 0;
		if (!excludeIndex[0].equalsIgnoreCase("@")) {
			while (!(excludeIndex[count].equalsIgnoreCase("@"))) {
				// System.out.println(excludeIndex[count]);
				count++;
			}
			System.out.println("");
		} else {
			System.out.println("None");
		}
	}

	// Info of a student
	public void studentInfo() {

		// get Index
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Index No: ");
		String index = sc.next();
		System.out.println("");

		FileHandling obj = new FileHandling();
		String[] fields = (obj.read(index)).split("#");

		// print student information
		System.out.print("INDEX NO: ");
		System.out.println(fields[0]);
		System.out.print("ELEGIBLE FOR: ");
		System.out.println(fields[1]);
		System.out.print("LEVEL 04 MARKS: ");
		System.out.println(fields[2]);
		System.out.print("LEVEL 05 MARKS:");
		System.out.println(fields[3]);
		System.out.print("LEVEL 06 MARKS:");
		System.out.println(fields[4]);
		System.out.println("");
	}

}
