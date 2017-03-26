
public class Class_Calc {

	Double[] l5markList = new Double[5];
	Double[] l6markList = new Double[3];
	double drop5 = 0;
	double drop6 = 0;
	boolean dropped40 = false;
	int points5 = 0;
	int points6 = 0;

	public void sort(String index) {
		try {

			FileHandling handler = new FileHandling();
			String[] fields = handler.read(index).split("#");

			// level5 sort
			String[] l5Marks = (fields[3]).split("/");
			String[] marks5 = new String[2];

			marks5 = l5Marks[0].split("-");
			drop5 = Double.parseDouble(marks5[0]);

			for (int i = 1, j = 0; i < 6 && j < 5; i++) {
				marks5 = l5Marks[i].split("-");
				if (Double.parseDouble(marks5[0]) >= drop5) {
					l5markList[j] = Double.parseDouble(marks5[0]);
					j++;
				} else {
					l5markList[j] = drop5;
					drop5 = Double.parseDouble(marks5[0]);
					j++;
				}
			}

			// level6 sort
			String[] l6Marks = (fields[4]).split("/");
			String[] marks6 = new String[2];

			marks6 = l6Marks[0].split("-");
			drop6 = Double.parseDouble(marks6[0]);

			for (int i = 1, j = 0; i < 5 && j < 3; i++) {
				marks6 = l6Marks[i].split("-");
				if (i != 4) {
					if (Double.parseDouble(marks6[0]) >= drop6) {
						l6markList[j] = Double.parseDouble(marks6[0]);
						j++;
					} else {
						l6markList[j] = drop6;
						drop6 = Double.parseDouble(marks6[0]);
						j++;
					}
				} else if (i == 4) {
					if (Double.parseDouble(marks6[0]) >= drop6) {
						l6markList[j] = Double.parseDouble(marks6[0]);
						j++;
					} else {
						l6markList[j] = drop6;
						drop6 = Double.parseDouble(marks6[0]);
						j++;
						dropped40 = true;
					}
				}
			}

			/*
			 * System.out.println(l5markList[0]);
			 * System.out.println(l5markList[1]);
			 * System.out.println(l5markList[2]);
			 * System.out.println(l5markList[3]);
			 * System.out.println(l5markList[4]); System.out.println(drop5);
			 * 
			 * System.out.println(l6markList[0]);
			 * System.out.println(l6markList[1]);
			 * System.out.println(l6markList[2]); System.out.println(drop6);
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void calc(String index) {
		try {
			sort(index);

			// L5 has the least one
			if (drop6 > drop5) {
				// L5set
				for (int i = 0; i < 4; i++) {
					if (l5markList[i] >= 40) {
						points5 += 20;
					}
				}

				// L6set
				if (dropped40) {
					if (l6markList[0] >= 40) {
						points6 += 20;
					}
					if (l6markList[1] >= 40) {
						points6 += 20;
					}
					if (l6markList[2] >= 40) {
						points6 += 20;
					}
					if (drop6 >= 40) {
						points6 += 40;
					}
				} else {
					if (l6markList[0] >= 40) {
						points6 += 20;
					}
					if (l6markList[1] >= 40) {
						points6 += 20;
					}
					if (l6markList[2] >= 40) {
						points6 += 40;
					}
					if (drop6 >= 40) {
						points6 += 20;
					}
				}

			}
			// L6 has the least one
			if (drop5 >= drop6) {
				// L5set
				for (int i = 0; i < 4; i++) {
					if (l5markList[i] >= 40) {
						points5 += 20;
					}
				}
				if (drop5 >= 40) {
					points5 += 20;
				}

				// L6set
				if (dropped40) {
					if (l6markList[0] >= 40) {
						points6 += 20;
					}
					if (l6markList[1] >= 40) {
						points6 += 20;
					}
					if (l6markList[2] >= 40) {
						points6 += 20;
					}
				} else {
					if (l6markList[0] >= 40) {
						points6 += 20;
					}
					if (l6markList[1] >= 40) {
						points6 += 20;
					}
					if (l6markList[2] >= 40) {
						points6 += 40;
					}
				}
			}

			double points = (points5 / 3) + ((points6 * 2) / 3);
			if (points >= 70 && points <= 100) {
				System.out.println("1st Class Degree");
			} else if (points >= 60) {
				System.out.println("2nd Class Upper Degree");
			} else if (points >= 50) {
				System.out.println("2nd Class Lower Degree");
			} else if (points >= 40) {
				System.out.println("3rd Class Hounours Degree");
			} else {
				System.out.println(" Error Occured! ");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

}
