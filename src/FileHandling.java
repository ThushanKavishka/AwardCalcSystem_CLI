import java.io.*;
import java.io.File;
import java.io.IOException;

public class FileHandling {

	// Create file
	public void create(String index) {
		try {
			File file = new File((index.toString()) + ".txt");

			if (file.createNewFile()) {
				System.out.println("NEW STUDENT HAS BEEN REGISTERED");
				System.out.println("Level: L4 ");
			} else
				System.out.println("Error : file already exists.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// write to the file
	public void write(String index, String data) {
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(index, false));
			// System.out.println(data);
			out.write(data);
			out.close();
			// System.out.println("Student File Created successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// read from file
	public String read(String index) {
		String str = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(index));
			str = in.readLine();
			// System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public void append(String file, String index) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
			// System.out.println(data);
			out.write((index + "/"));
			out.close();
			// System.out.println("Student File Created successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Create file
	public void listCreate(String index) {
		try {
			File file = new File((index.toString()) + ".txt");

			if (file.createNewFile()) {
				System.out.println("List File Created");
			} else
				System.out.println("Error : file already exists.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
