package filmDatabaseApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This class is used to show the interface to user and set
 *         how each button can be used. This class is belongs to "Control" of
 *         MVC.
 * 
 * @author RuotongXu 
 *
 */
public class FilmListApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private FilmList model;
	private FilmListPanel view;

	/**
	 * This method is used to get what film user chose in interface and make the remove button is available for user.
	 */
	private void eventHandleListSelection() {
		this.view.getRemoveButton().setEnabled(this.view.getfilmList().getSelectedIndex() != -1);
	}

	/**
	 * This method is used to released the add, clear, search buttons while the text bar has value.
	 * @param e
	 */
	private void eventHandleKeyReleased(KeyEvent e) {

		this.view.getAddButton().setEnabled(!this.view.getfilmNameTextField().getText().isEmpty());
		this.view.getClearButton().setEnabled(!this.view.getfilmNameTextField().getText().isEmpty());
		this.view.getSearchButton().setEnabled(!this.view.getfilmNameTextField().getText().isEmpty());
	}

	/**
	 * This method is used to call the remove function while the user choose the film and click remove button.
	 */
	private void eventHandleRemoveButton() {
		int index = this.view.getfilmList().getSelectedIndex();
		if (index != -1) {
			this.model.removefilmItem(index);
		}
		this.view.update();
	}

	/**
	 * This method is used to printout a hit while user open this app.
	 */
	private void eventHandleWindowOpened() {
		System.out.println("Window opened!");
		this.view.update();
	}

	/**
	 * This method is used to save the filmlist into a txt file and renew the pane.
	 */
	private void eventHandleSaveButton() {
		ReadFilmListDataFile.savefilmList(this.model);
		this.view.update();
	}

	/**
	 * This method is used to load the txt file and renew the pane.
	 * 
	 */
	private void eventHandleLoadButton() {
		ReadFilmListDataFile.loadfilmList(this.model);
		this.view.update();
	}

	/**
	 * This method is used to add the film which is in the text bar 
	 * if this film is not in the film list and the name of film is not empty.
	 */
	private void eventHandleAddButton() {
		String text = this.view.getfilmNameTextField().getText().trim();
		Film f = new Film(text);
		if ((!text.isEmpty()) && (!this.model.hasfilmItem(f))) {
			this.model.addfilm(f);
			this.view.getfilmNameTextField().setText("");
		}
		this.view.update();
	}
    /**
     * This method is used to search the film from the film list, the film name is in text
     * bar, and it will transfer to lower case. Using a for loop to search the film list has 
     * the film or not. If no film is found, printout there has no such film, 
     * Once a film is found, the search list will store the film name and the
     * counter(temp) will plus one. Finally printout the search list in pane and printout how
     * much film has been found(temp).
     */
	private void eventHandleSearchButton() {
		ReadFilmListDataFile.loadfilmList(this.model);
		String text = this.view.getfilmNameTextField().getText().toLowerCase();
		FilmList search = new FilmList();
		int temp = 0;
		for (Film m : this.model.getfilmList()) {
			if (m.hasfilm(text)) {
				search.addfilm(m);
			}
		}
		if (search.getfilmList().length == 0) {
			this.model.clear();
			this.view.update();
			System.out.println("Sorry, No such film has found.");
		} else {
			this.model.clear();
			for (int i = 0; i < search.getfilmList().length; i++) {
				this.model.addfilm(search.getfilmList()[i]);
				temp++;
			}
			this.view.update();
			System.out.println(temp+" film has been found");
		}
	}
    /**
     * This method is used to clear the text bar and show the film list.
     */
	private void eventHandleClearButton() {
		this.view.getfilmNameTextField().setText("");
		ReadFilmListDataFile.loadfilmList(this.model);
		this.view.update();
	}
	/**
	 * The constructor initialises the model and loads data from a text file
	 * database. The view is constructed and added to the content pane. All event
	 * handlers for the buttons,lists,fields etc are registered with the appropriate
	 * component. JFrame is fixed size and has no layout manager.
	 * 
	 */
	public FilmListApp(String name) {
		super(name);

		this.model = new FilmList();
		ReadFilmListDataFile.loadfilmList(this.model);

		this.view = new FilmListPanel(this.model);

		this.view.getLoadButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleLoadButton();
			}
		});

		this.view.getSearchButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleSearchButton();
			}
		});

		this.view.getClearButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleClearButton();
			}
		});

		this.view.getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleSaveButton();
			}
		});

		// set event listeners for the view here
		this.view.getfilmNameTextField().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});

		this.view.getRemoveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleRemoveButton();
			}
		});

		this.view.getAddButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleAddButton();
			}
		});

		this.view.getfilmList().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				eventHandleListSelection();
			}

		});

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				eventHandleWindowOpened();
			}
		});

		// Choose to lay out components manually
		this.getContentPane().setLayout(null);
		// add the view to this content pane.
		this.getContentPane().add(this.view);

		// Set program to stop when window closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(290, 270); // manually computed sizes
		this.setLayout(null);
		setResizable(false);
	}

	/**
	 * This is the main class which call the constructor of app class
	 * and let user can see the interface of this application.
	 * This program is used to storage a film list and user can add, search a film by
	 * enter the name of this film, user can also delete a film by select the film in user
	 * interface.The list of the film can be storaged in text file and the text file can
	 * also be load by this application.
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new FilmListApp("My film List");
		frame.setVisible(true);
	}
}