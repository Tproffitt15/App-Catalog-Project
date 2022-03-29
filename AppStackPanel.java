import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.*;

/**
 * Java class called AppStackPanel that extends JPanel. 
 * Displays a graphical user interface. It has two panels that users can navigate to.
 * The components added to these panels are JLabels, JTextFields and JButtons.
 * @author Troy Proffitt, Darcy Hayes, Anna Martin, Clark Seese
 */

public class AppStackPanel extends JPanel {
	
	// Initialize Variables
	// Panels
	JPanel cards;
	JPanel loginPanel;
	JPanel searchPanel;
	
	// Layout
	CardLayout cardLayout;
	
	// Buttons
	JButton logBtn;
	JButton forgotBtn;
	JButton searchB;
	
	// Text fields
	JTextField username;
    JTextField password;
    JTextField searching;
    
    // Strings 
    String appFile;
    String loginFile;
    String userCheck;
    String passCheck;
    String searchMade;
    String currentLine;
    String[] arr;
    
    // Scanners
    Scanner fin;
    
    // JTextAreas
    JTextArea result;
    
    // JScrollBar + JScrollPane
    JScrollBar scrollBar;
    JScrollPane scrollPane;
	
	public AppStackPanel() {
		cards = new JPanel();
		cards.setLayout(cardLayout = new CardLayout());
		
		// Login Page
		loginPanel = new JPanel();
		loginPanel.setSize(AppStackFrame.SCREEN_WIDTH, AppStackFrame.SCREEN_HEIGHT);
		
		logBtn = new JButton("Login");
		forgotBtn = new JButton("Forgot username/password");
		loginPanel.add(logBtn, new GridBagConstraints());
		loginPanel.add(forgotBtn);
		
		username = new JTextField(10);
        password = new JTextField(10);
        loginPanel.add(username);
        loginPanel.add(password);
        
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	userCheck = username.getText();
            	passCheck = password.getText();
                if (confirmLogin(userCheck, passCheck)) {
                	cardLayout.show(cards, "Search");
                	username.setText("");
                	logBtn.setVisible(false);
                	forgotBtn.setVisible(false);
                	username.setVisible(false);
                	password.setVisible(false);
     
                }
            }
        });
        
		
		// App Page
		// Reading from file
		appFile = new String("AppStackApps.txt");
		
		// Search box
		result = new JTextArea(30, 50);
		result.setEditable(false);
		
		searchPanel = new JPanel();
		scrollBar = new JScrollBar();
		scrollPane = new JScrollPane(result);
		searching = new JTextField(30);
		
		searchB = new JButton("Search");
		// Displaying apps upon searching, rough draft
		searchB.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 try {	
            		 // sets text area empty once a search is made
            		 result.setText("");
            		 
            		 // takes search word from the search bar
            		 searchMade = searching.getText().toLowerCase();
            		 
            		 // creates a new scanner from the text file of apps
         			 fin = new Scanner(new File(appFile));
         			
         			 while(fin.hasNext()) {
         				// performs a search using the search word in the search bar
         				currentLine = fin.nextLine();
         				if (currentLine.toLowerCase().contains(searchMade)) {
         						arr = currentLine.split(",");
         							result.append("App: " + arr[0] + "\n");
         							result.append("Description: " + arr[1] + "\n");
         							result.append("Publisher: " + arr[2] + "\n");
         							result.append("Platform: " + arr[3] + "\n");
         							result.append("Version: " + arr[4] + "\n");
         							result.append("Link: " + arr[5] + "\n");
         							result.append("Price: $" + arr[6] + "\n------------- \n");
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
		
		// Adding pages
		cards.add(loginPanel, "Login");
		cards.add(searchPanel, "Search");
		
		this.add(cards);
		 
	}
	
	public boolean confirmLogin(String user, String pass) {
    	try {
    		loginFile = "Logins.txt";
   		 	// creates a new scanner from the text file of apps
			fin = new Scanner(new File(loginFile));
			
			// Setting to lowercase for clarity
			user.toLowerCase();
			pass.toLowerCase();
			while(fin.hasNext()) {
 				// performs a search using the search word in the search bar
 				currentLine = fin.nextLine();
 				arr = currentLine.split(",");
 				if (arr[0].equals(user) && arr[1].equals(pass)) {
 					return true;
 				}
 				
			}
    		
    	} catch (Exception f) {
 			f.printStackTrace();
 		}
    	
    	return false;
    }
	
}
