import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

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
		
		// Reading from file
		String appFile = new String("AppStackApps.txt");
		
		// Search box
		JTextArea result = new JTextArea(30, 50);
		result.setEditable(false);
		
		JPanel searchPanel = new JPanel();
		JScrollBar scrollBar = new JScrollBar();
		JScrollPane scrollPane = new JScrollPane(result);
		JTextField searching = new JTextField(30);
		
		JButton searchB = new JButton("Search");
		// Displaying apps upon searching, rough draft
		searchB.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 try {
            		 // sets text area empty once a search is made
            		 result.setText("");
            		 
            		 // takes search word from the search bar
            		 String searchMade = searching.getText().toLowerCase();
            		 
            		 // creates a new scanner from the text file of apps
         			Scanner fin = new Scanner(new File(appFile));
         			
         			while(fin.hasNext()) {
         				// performs a search using the search word in the search bar
         				String currentLine = fin.nextLine();
         				if (currentLine.toLowerCase().contains(searchMade)) {
         						String[] arr = currentLine.split(",");
         							result.append("App: " + arr[0] + "\n");
         							result.append("Description: " + arr[1] + "\n");
         							result.append("Publisher: " + arr[2] + "\n");
         							result.append("Platform: " + arr[3] + "\n");
         							result.append("Version: " + arr[4] + "\n");
         							result.append("Link: " + arr[5] + "\n ---------- \n");
         				}
         			}
         		} catch (Exception f) {
         			f.printStackTrace();
         		}
             }
         });
	
		
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
		
		//add(panel);
		
		add(panel, BorderLayout.NORTH);
		add(searchPanel, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		MyWindow window = new MyWindow();
		window.setTitle("APPStack");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
	}
}
