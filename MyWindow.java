import java.awt.BorderLayout;
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
 * @author Troy Proffitt, Darcy Hayes
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
		JScrollPane scrollPane = new JScrollPane(result);
		
		searchPanel.add(searching);
		searchPanel.add(searchB);
		searchPanel.add(scrollPane);
		
		
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
		window.setTitle("Course Project");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
