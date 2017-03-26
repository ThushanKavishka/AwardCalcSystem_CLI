import java.util.*;
import java.io.*;

public class Registration {

	// Variables to be filled
	String index;
	String level = "level 4";
	String L4Marks = "0";
	String L5Marks = "0";
	String L6Marks = "0";

	public void Regis() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Index No: ");
		index = input.next();
		try {
			FileHandling handler = new FileHandling();
			handler.create(index);
			handler.write(index, index + "#" + level + "#" + L4Marks + "#" + L5Marks + "#" + L6Marks);
			handler.append("Stud_List", index);

			// handler.read(index);
		} catch (Exception e) {
			System.out.println("ERROR OCCURED");
		}

	}

}
