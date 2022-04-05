import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;

import javax.swing.border.Border;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

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
	JPanel createAccPanel;
	JPanel searchPanel;
	
	// Layout
	CardLayout cardLayout;
	
	// Buttons
	JButton logBtn;
	JButton forgotBtn;
	JButton searchB;
	JButton createBtn;
	JButton alreadyBtn;
	
	// Text fields
	JTextField username;
    JTextField password;
    JTextField searching;
    JTextField newUsername;
    JTextField newPassword;
    
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
    PrintWriter pw;
    FileWriter fw;
    
    // JTextAreas
    JTextArea result;
    
    // JScrollBar + JScrollPane
    JScrollBar scrollBar;
    JScrollPane scrollPane;
    
    int [] rowIndex;
    int [] colIndex;
	
	public AppStackPanel() {
		cards = new JPanel();
		cards.setLayout(cardLayout = new CardLayout());
		
		// Create account page
		createAccPanel = new JPanel();
		createAccPanel.setSize(AppStackFrame.SCREEN_WIDTH, AppStackFrame.SCREEN_HEIGHT);
		createAccPanel.setBackground(Color.LIGHT_GRAY);
		// Username
		JLabel newUser = new JLabel("Username");
		createAccPanel.add(newUser);
		newUsername = new JTextField(10);
		createAccPanel.add(newUsername);
        
        // Password
		JLabel newPass = new JLabel("Password");
		newPassword = new JTextField(10);
        createAccPanel.add(newPass);
        createAccPanel.add(newPassword);
        
        // Buttons
		createBtn = new JButton("Create account");
		createAccPanel.add(createBtn, new GridBagConstraints());
		alreadyBtn = new JButton("Already have an account?");
		createAccPanel.add(alreadyBtn);

        
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	userCheck = newUsername.getText();
            	passCheck = newPassword.getText();
                if (createAccount(userCheck, passCheck)) {
                	cardLayout.show(cards, "Login");
                }
            }
        });
        
        alreadyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Login");
            }
        });
        
		
		// Login Page
		loginPanel = new JPanel();
		loginPanel.setSize(AppStackFrame.SCREEN_WIDTH, AppStackFrame.SCREEN_HEIGHT);
		
		// Username
		JLabel userLabel = new JLabel("Username");
		loginPanel.add(userLabel);
		username = new JTextField(10);
        loginPanel.add(username);
        
        // Password
		JLabel passLabel = new JLabel("Password");
        password = new JTextField(10);
		loginPanel.add(passLabel);
        loginPanel.add(password);
        
        // Buttons
		logBtn = new JButton("Login");
		forgotBtn = new JButton("Forgot username/password");
		loginPanel.add(logBtn, new GridBagConstraints());
		loginPanel.add(forgotBtn);
        
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
		
		JTable searchTable = new JTable();
		
		searchB = new JButton("Search");

		InsertFileDataToJTable model = new InsertFileDataToJTable();
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		JTable table = new JTable(model);
		table.setRowSorter(sorter);
		table.getColumnModel().getColumn(0).setHeaderValue("App");
		table.getColumnModel().getColumn(1).setHeaderValue("Desc");
		table.getColumnModel().getColumn(2).setHeaderValue("Publisher");
		table.getColumnModel().getColumn(3).setHeaderValue("Platform");
		table.getColumnModel().getColumn(4).setHeaderValue("Version");
		table.getColumnModel().getColumn(5).setHeaderValue("Link");
		table.getColumnModel().getColumn(6).setHeaderValue("Price");
		

		searchB.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 try {	
            		 
            		searchMade = searching.getText().trim();
            		
            		if (searchMade.length() != 0) {
            			searchMade = searchMade.substring(0, 1).toUpperCase() + searchMade.substring(1);
            			searchMade = searchMade.substring(1, searchMade.length()).toLowerCase();
            		}	
            			
            		RowFilter<TableModel, Object> rf = null;
            	    //If current expression doesn't parse, don't update.
            	    try {
            	        rf = RowFilter.regexFilter(searchMade, 0);
            	    } catch (java.util.regex.PatternSyntaxException f) {
            	    	
            	        return;
            	    }
            	    sorter.setRowFilter(rf);
     	            sorter.setRowFilter(RowFilter.regexFilter(searchMade));

            		
         		} catch (Exception f) {
         			f.printStackTrace();
         		}
             }
         });
		
		rowIndex = table.getSelectedRows();
        colIndex = table.getSelectedColumns();
	
		
		JButton displayReview = new JButton("Reviews");
		displayReview.setMnemonic(KeyEvent.VK_C);
	    displayReview.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		int[] selectedRows= table.getSelectedRows();
	    		int[] selectedColumns = table.getSelectedColumns();
	    		String reviewText = "";
	    		String reviewsName = (table.getValueAt(selectedRows[0], 0)) + "Reviews.txt";
	    		try {
	    			fin = new Scanner(new File(reviewsName));
	    			while(fin.hasNext()) {
         				currentLine = fin.nextLine();
         				arr = currentLine.split("//");
         				for (int i = 0; i < arr.length; i++) {
         					reviewText += "Review " + (i + 1) + ": " + arr[i] + "\n";
         				}
	    			}
	    			
	    			
	    		} catch (Exception g) {
	    			g.printStackTrace();
	    		}
	    		
	    		JOptionPane.showMessageDialog(null, reviewText);
	    	    
	    	}
	    });
	    
		JButton displayDesc = new JButton("Description");
		
		
		// JTable
		
		
		table.setRowHeight(30);
		//table.setRowHeight(10, 50);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(600, 800));
		
		// Panel
		searchPanel.setSize(1000, 1000);
		searchPanel.add(scrollpane, BorderLayout.NORTH);
		searchPanel.add(searching, BorderLayout.SOUTH);
		searchPanel.add(searchB, BorderLayout.SOUTH);
		//searchPanel.add(scrollPane, BorderLayout.SOUTH);
		//searchPanel.add(scrollBar);
		searchPanel.add(displayReview, BorderLayout.SOUTH);
		searchPanel.add(displayDesc, BorderLayout.SOUTH);
		
		// Adding pages
		cards.add(createAccPanel, "Create Account");
		cards.add(loginPanel, "Login");
		cards.add(searchPanel, "Search");
		
		this.add(cards);
		 
	}
	
	
	
	public boolean createAccount(String user, String pass) {
    	try {    		
    		loginFile = "Logins.txt";
    		
    		fin = new Scanner(new File(loginFile));
    		
    		// Setting to lowercase for clarity
    		user.toLowerCase();
    		pass.toLowerCase();
    		while(fin.hasNext()) {
    		 	// performs a search using the search word in the search bar
    		 	currentLine = fin.nextLine();
    		 	arr = currentLine.split(",");
    		 	if (arr[0].equals(user) && arr[1].equals(pass)) {
    		 		return false;
    		 	}
    		 				
    		}
    		
    		fw = new FileWriter(loginFile, true);
			fw.write("\n" + user + "," + pass + "," + "user");
			fw.close();
    		
    	} catch (Exception f) {
 			f.printStackTrace();
 		}
    	
    	return true;
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
