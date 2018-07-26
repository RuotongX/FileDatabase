package filmDatabaseApp;

import java.util.ArrayList;

/**
 * This class is used to simulate the list of the films that database storage and
 * belongs to "Modeling" in MVC.
 * This class maintains a list of film objects with functionality to add and
 * remove films from the list.
 * 
 */

public class FilmList {
	private ArrayList<Film> filmItems;

	/**
	 * This is a constructor of this class which can create a new array for film.
	 */
	public FilmList() {
		this.filmItems = new ArrayList<Film>();
	}

	/**
	 * This method is used to add a film to the array of film.
	 * 
	 * @param afilm
	 *            A film object.
	 */
	public void addfilm(Film afilm) {
		this.filmItems.add(afilm);
	}

	/**
	 * This method is used to delete a film by the number of the film in the array
	 * list.
	 * 
	 * @param index
	 *            number
	 */
	public void removefilmItem(int index) {
		this.filmItems.remove(index);
	}

	/**
	 * This method is used to get the film array by rewrite the array list into a normal array.
	 * 
	 * @return array
	 */
	public Film[] getfilmList() {
		Film[] array = new Film[this.filmItems.size()];

		for (int i = 0; i < array.length; i++) {
			array[i] = this.filmItems.get(i);
		}

		return array;
	}

	/**
	 * This method used to check the film array has the input film or not, if it
	 * has, return true.
	 * 
	 * @param afilm
	 *            a film object.
	 * @return
	 */
	public boolean hasfilmItem(Film afilm) {
		return this.filmItems.contains(afilm);
	}

	/**
	 * This method is used to clear the film array so that no film storage in this
	 * array.
	 */
	public void clear() {
		this.filmItems.clear();
	}
}
