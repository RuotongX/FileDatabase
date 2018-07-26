package filmDatabaseApp;

/**
 * 
 * This class contains two static methods which read and write a database of films.
 *  @author RuotongXu 
 * 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadFilmListDataFile {

	public static final String filmListDataFilePath = "filmlistdata/";
	public static final String filmListDataFileName = "films.txt";

	// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * Writes the text file filmListDataFileName of the films in supplied filmList
	 * object
	 * 
	 * @param fl
	 *            a film list to store in the database
	 * 
	 * 
	 */
	public static void savefilmList(FilmList fl) {
		try {

			try (PrintWriter fileWriter = new PrintWriter(new File(filmListDataFilePath + filmListDataFileName))) {
				fileWriter.println(fl.getfilmList().length);
				for (Film film : fl.getfilmList()) {
					fileWriter.println(film.getName());
				}
				fileWriter.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------
	/**
	 * Reads the text file filmListDataFileName of the films in supplied filmList
	 * object
	 * 
	 * @param fl
	 *            a film list which will be cleared of existing films to store the
	 *            films read from the database.
	 * 
	 * 
	 */

	public static void loadfilmList(FilmList fl) {

		try {

			Scanner fileScan = new Scanner(new File(filmListDataFilePath + filmListDataFileName));

			int nfilms = fileScan.nextInt();
			fileScan.nextLine();
			fl.clear();

			for (int i = 1; i <= nfilms; i++) {
				String name = fileScan.nextLine();
				Film afilm = new Film(name);
				fl.addfilm(afilm);
			}

			fileScan.close();
			System.out.println("Database Loaded " + nfilms + " films");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	// ---------------------------------------------------------------------------------------------------------------------
}
