
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.*;


/**
 * Java class called MyWindow that extends JFrame. 
 * Displays a graphical user interface. It has three panels added to the JFrame i.e. MyWindow. 
 * The components added to these panels are JLabels, JTextFields and JButtons.
 * @author Troy Proffitt, Darcy Hayes, Anna Martin, Clark Seese
 */
public class MyWindow extends JFrame {
	
	public MyWindow() {
		JPanel panel = new JPanel();
		
		JPanel title = new JPanel();
		JPanel account = new JPanel();
		JPanel buttons = new JPanel();
		panel.add(title);
		panel.add(account);
		panel.add(buttons);
		
		
		// Search box
		JTextField searching = new JTextField(30);
		JButton searchB = new JButton("Search");
		JTable result = new JTable();
		JPanel searchPanel = new JPanel();
		JScrollBar scrollBar = new JScrollBar();
		JScrollPane scrollPane = new JScrollPane(result);
		
		searchPanel.add(searching, BorderLayout.NORTH);
		searchPanel.add(searchB, BorderLayout.NORTH);
		searchPanel.add(scrollPane, BorderLayout.SOUTH);
		searchPanel.add(scrollBar);
		
		
		// title
		JLabel system = new JLabel("Course Project");
		title.add(system);
		
		// buttons
		JButton signIn = new JButton("Sign in");
		JButton forgotPass = new JButton("Forgot username/password");
		buttons.add(signIn, BorderLayout.EAST);
		buttons.add(forgotPass, BorderLayout.WEST);
		
		
		// account
		JLabel userName = new JLabel("Username");
		JLabel password = new JLabel("Password");
		
		JTextField enterUser = new JTextField("Enter your username");
		JTextField enterPass = new JTextField("Enter your password");
		account.setLayout(new GridLayout(2, 2));
		account.add(userName);
		account.add(password);
		account.add(enterUser);
		account.add(enterPass);
		
		add(panel);
		
		add(panel, BorderLayout.NORTH);
		add(searchPanel, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		MyWindow window = new MyWindow();
		window.setTitle("APPStack");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
		
		/*
		 * Next step is to implement a database and add applications.
		 * After these steps, the search bar can be made functional
		 * and the add details task can be completed.
		 * 
		 * example of potential use of mongo db:
		 * MongoClient mongoClient = MongoClients.create("mongodb+srv://<anna>:<abcd1234>@cluster0.yrcpl.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		 * DB database = mongoClient.getDB("AppStack");
		 * DBCollection collection = database.getCollection("AppInformation");
		 * 
		 * - needs certain dependencies to function, running into errors - Anna
		 */
		
	}
}
