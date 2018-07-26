package filmDatabaseApp;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

/**
 * This class is used to design how the GUI looks like. The view of the
 * application belongs MVC. Contains all JComponents to display the filmList
 * model. each button/field etc has a get method for access outside of the
 * filmListPanel class.
 * 
 * @author Ruotong Xu
 * 
 */
public class FilmListPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FilmList model;

	private JList<Film> filmList;
	private JTextField filmNameInput;

	private JButton addButton;
	private JButton removeButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton searchButton;
	private JButton clearButton;

	/**
	 * This method is used to return a private JButton.
	 * 
	 * @return
	 */
	public JButton getSaveButton() {
		return this.saveButton;
	}

	/**
	 * This method is used to return a private JButton.
	 * 
	 * @return
	 */
	public JButton getLoadButton() {
		return this.loadButton;
	}

	/**
	 * This method is used to return the list of the film.
	 * 
	 * @return
	 */
	public JList<Film> getfilmList() {
		return this.filmList;
	}

	/**
	 * This method is used to return a private JButton.
	 * 
	 * @return
	 */
	public JTextField getfilmNameTextField() {
		return this.filmNameInput;
	}

	/**
	 * This method is used to return a private JButton.
	 * 
	 * @return
	 */
	public JButton getRemoveButton() {
		return this.removeButton;
	}

	/**
	 * This method is used to return a private JButton.
	 * 
	 * @return
	 */
	public JButton getAddButton() {
		return this.addButton;
	}

	/**
	 * This method is used to return a private JButton.
	 * 
	 * @return
	 */
	public JButton getSearchButton() {
		return this.searchButton;
	}

	/**
	 * This method is used to return a private JButton.
	 * 
	 * @return
	 */
	public JButton getClearButton() {
		return this.clearButton;
	}
	/**
	 * This is a constructor of this class which require to input a array(filmlist) and create the interface for users which has the information for each button, window, pane.  
	 * @param model
	 */
	public FilmListPanel(FilmList model) {
		this.model = model;// set the model.

		setLayout(null);// Choose to lay out components manually

		this.filmList = new JList<Film>(this.model.getfilmList());

		this.filmList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(filmList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLocation(10, 75);
		scrollPane.setSize(150, 150);

		this.add(scrollPane);

		// add the film name input text field...
		this.filmNameInput = new JTextField("Film");
		this.filmNameInput.setLocation(10, 10);
		this.filmNameInput.setSize(150, 25);
		this.add(filmNameInput);

		// Add the ADD button
		this.addButton = new JButton("Add");
		addButton.setLocation(175, 10);
		addButton.setSize(100, 25);
		this.add(addButton);

		// Add the REMOVE button
		removeButton = new JButton("Remove");
		removeButton.setLocation(175, 45);
		removeButton.setSize(100, 25);
		this.add(removeButton);

		// Add the Save button
		this.saveButton = new JButton("Save");
		saveButton.setLocation(175, 45 + 35);
		saveButton.setSize(100, 25);
		this.add(saveButton);

		// Add the Load button
		this.loadButton = new JButton("Load");
		loadButton.setLocation(175, 45 + 35 * 2);
		loadButton.setSize(100, 25);
		this.add(loadButton);

		// Add the Search button
		this.searchButton = new JButton("Search");
		searchButton.setLocation(175, 45 + 35 * 3);
		searchButton.setSize(100, 25);
		this.add(searchButton);

		// Add the Clear button
		this.clearButton = new JButton("Clear");
		clearButton.setLocation(175, 45 + 35 * 4);
		clearButton.setSize(100, 25);
		this.add(clearButton);

		setSize(290, 300); // manually computed sizes
		this.update();
	}

	// ---------------------------------------------------------------------------------------------------------------------
	/***
	 * The update method is called by most event handler methods in the FilmListApp.
	 * 
	 */
	public void update() {
		this.filmList.setListData(this.model.getfilmList());
		this.addButton.setEnabled(!this.filmNameInput.getText().isEmpty());
		this.removeButton.setEnabled(this.filmList.getSelectedIndex() != -1);
		this.clearButton.setEnabled(!this.filmNameInput.getText().isEmpty());
		this.searchButton.setEnabled(!this.filmNameInput.getText().isEmpty());
	}
	// ---------------------------------------------------------------------------------------------------------------------
}
