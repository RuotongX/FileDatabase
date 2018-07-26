package filmDatabaseApp;

/**
 * This class is used to store the films information.
 * 
 * @author Ruotong Xu
 *
 */ 	
public class Film {
	private String name;		

	/**
	 * This is the constructor of this class which can set the name from input.
	 * 
	 * @param name
	 *            the name of the film.
	 */
	public Film(String name) {
		this.setName(name);
	}

	/**
	 * This method is used to override the the toString to express the class which
	 * is the film name.
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * This method is used to get the name the name of the film..
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is used to set the name the name of the film..
	 * 
	 * @param name
	 *            the name of the film.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is used to compare the text that user input with the exist film,
	 * if films' name has the same text, return a true value. This method also use
	 * the tolowercase to ensure user input all in lower case but not upper case, so
	 * that program can compare to the films which are exist.
	 * 
	 * @param name
	 *            the name of the film.
	 * @return
	 */
	public boolean hasfilm(String film) {
		String tokens = this.name.toLowerCase();
		if (tokens.contains(film)) {
			return true;
		} else {
			return false;
		}
	}
}
