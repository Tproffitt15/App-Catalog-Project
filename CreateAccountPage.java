import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CreateAccountPage extends JFrame {
	public CreateAccountPage() {
		JFrame frame = new JFrame("Create Account");
		
		JPanel createAccPanel = new JPanel();
		createAccPanel.setSize(600, 500);
		
		// Username
		JLabel userLabel = new JLabel("Username");
		createAccPanel.add(userLabel);
		JTextField username = new JTextField(10);
		createAccPanel.add(username);
        
        // Password
		JLabel passLabel = new JLabel("Password");
		JTextField password = new JTextField(10);
		createAccPanel.add(passLabel);
		createAccPanel.add(password);
        
        // Buttons
		JButton createBtn = new JButton("Create account");
		createAccPanel.add(createBtn, new GridBagConstraints());
        JButton alreadyBtn = new JButton("Already have an account?");
		createAccPanel.add(alreadyBtn);
        
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String userCheck = username.getText();
            	String passCheck = password.getText();
                if (createAccount(userCheck, passCheck)) {
                	frame.dispose();
                	LoginPage loginPage = new LoginPage();
                }
            }
        });
        
    	
    	alreadyBtn.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		  LoginPage loginPage = new LoginPage();
    		  frame.dispose();
    	  }
    	});
		
		
		// Creates Window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createAccPanel);
        frame.setSize(400, 150);
        frame.setVisible(true);
	}
	public boolean createAccount(String user, String pass) {
    	try {    		
    		String loginFile = "Logins.txt";
    		
    		Scanner fin = new Scanner(new File(loginFile));
    		
    		// Setting to lowercase for clarity
    		user.toLowerCase();
    		pass.toLowerCase();
    		while(fin.hasNext()) {
    		 	// performs a search using the search word in the search bar
    		 	String currentLine = fin.nextLine();
    		 	String[] arr = currentLine.split(",");
    		 	if (arr[0].equals(user) && arr[1].equals(pass)) {
    		 		return false;
    		 	}
    		 				
    		}
    		
    		FileWriter fw = new FileWriter(loginFile, true);
			fw.write("\n" + user + "," + pass + "," + "user");
			fw.close();
    		
    	} catch (Exception f) {
 			f.printStackTrace();
 		}
    	
    	return true;
    }

	
	public boolean confirmLogin(String user, String pass) {
    	try {
    		String loginFile = "Logins.txt";
   		 	// creates a new scanner from the text file of apps
			Scanner fin = new Scanner(new File(loginFile));
			
			// Setting to lowercase for clarity
			user.toLowerCase();
			pass.toLowerCase();
			while(fin.hasNext()) {
 				// performs a search using the search word in the search bar
 				String currentLine = fin.nextLine();
 				String[] arr = currentLine.split(",");
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
