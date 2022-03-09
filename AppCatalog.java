import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This driver class implements the app catalog program.
 * 
 *
 */
public class AppCatalog {

	// Initializing global variables to be used.
	static ArrayList<App> apps = new ArrayList<App>();
	static Scanner keyboard = new Scanner(System.in);
	static boolean programRunning = true;
	static int choice;

	public static void main(String[] args) {

		// Loading apps from file.
		loadApps();
		programRunning = false;

		// Utilizing loop to keep replaying program unless user opts out.
		while (choice != 7) {

			// Displaying menu, prompting user for a choice, and storing the choice.
			System.out.println("App Catalog Operations:");
			System.out.println("1) Add");
			System.out.println("2) Remove");
			System.out.println("3) Save");
			System.out.println("4) Load");
			System.out.println("5) Display All");
			System.out.println("6) Search");
			System.out.println("7) Exit");
			System.out.print("Select an option (number): ");
			choice = keyboard.nextInt();
			keyboard.nextLine();

			// Utilizing switch statement to control flow the program depending on the
			// user's given choice.
			switch (choice) {
			case 1:
				addApp();
				break;
			case 2:
				removeApp();
				break;
			case 3:
				saveApps();
				break;
			case 4:
				loadApps();
				break;
			case 5:
				displayApps();
				break;
			case 6:
				searchApp();
				break;
			case 7:
				choice = 7;
				break;
			}
		}

		// Saving apps to file and confirming program's termination to the user.
		saveApps();
		System.out.println("The program has successfully terminated.");
	}

	/**
	 * This method adds an app to the address book.
	 */
	public static void addApp() {
		App app = new App();
		int id = 0; // will implement generation of a random unique id later
		System.out.println("Enter App Information: ");
		System.out.print("App Name: ");
		app.setName(keyboard.nextLine());
		System.out.print("Generate App ID: ");
		app.setAppID(id);
		System.out.println("Done: the app has been added.");
		System.out.println();
	}

	/**
	 * This method removes an app from the address book.
	 */
	public static void removeApp() {
		int index = -1;
		System.out.print("Enter App name: ");
		String name = keyboard.next();

		for (int i = 0; i < apps.size(); i++)
			if (apps.get(i).getName().equals(name))
				index = i;

		if (index == -1)
			System.out.println("Error: there is no app with that name.");
		else {
			apps.remove(index);
			System.out.println("Done: the app with that name has been removed.");
		}
		System.out.println();
	}

	/**
	 * This method saves the apps to file.
	 */
	public static void saveApps() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("appcatalog.dat"));
			out.writeObject(apps);
			out.close();
			System.out.println("Your app catalog has successfully been saved.");
		} catch (Exception e) {
			System.out.println("Error: your app catalog could not be saved.");
		}
		if (choice != 7)
			System.out.println();
	}

	/**
	 * This method loads the apps from file.
	 */
	public static void loadApps() {
		try {
			File file = new File("appcatalog.dat");
			if (file.exists() && file.length() != 0) {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				apps = (ArrayList<App>) in.readObject();
				in.close();
				if (programRunning == false) {
					System.out.println("Your app catalog have successfully been loaded.");
					System.out.println();
				}
			} else {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Error: your app catalog could not be loaded.");
			System.out.println();
		}
	}

	/**
	 * This method displays all the apps in the app catalog.
	 */
	public static void displayApps() {
		for (App x : apps)
			System.out.println(x);
		if (apps.size() == 0)
			System.out.println("The app catalog is empty.");
		System.out.println();
	}

	/**
	 * This method searches for a specific app based on a keyword given by the
	 * user and then displays the app.
	 */
	public static void searchApp() {
		System.out.print("Enter app keyword: ");
		String keyword = keyboard.nextLine();
		boolean found = false;
		for (int i = 0; i < apps.size(); i++) {
			if (apps.get(i).getName().contains(keyword)) {
				System.out.println(apps.get(i));
				found = true;
			}
		}
		if (found == false)
			System.out.println("Error: no app in your app catalog contains the given keyword.");
		System.out.println();
	}
}
