import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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

public class AppReviewPage extends JFrame {
	public AppReviewPage(String appName) {
		JFrame frame = new JFrame("Add a " + appName + " Review");
		JPanel panel = new JPanel();
		frame.add(panel);
		       
        ImageIcon appIcon = new ImageIcon(appName + ".jpg");
        Image image = appIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        appIcon.setImage(newimg);

        JLabel appLogo = new JLabel(appIcon);

        panel.add(appLogo);
        
        JButton addReviewBut = new JButton("Add Review");
        panel.add(addReviewBut);
        
        JTextArea area = new JTextArea();
        area.setEditable(true);
        area.setBounds (50, 100, 500, 300);
        
        JScrollPane scrollPane = new JScrollPane(area);

        frame.add(area);
        frame.add(scrollPane);

        addReviewBut.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	try {
           		 	// creates a new scanner from the text file of apps
            		String appFile = new String(appName + "Reviews" + ".txt");
            		FileWriter fw = new FileWriter(appFile, true);
        			fw.write(area.getText() + "\n");
        			fw.close();
        			frame.dispose();
        			
            	} catch (Exception f) {
         			f.printStackTrace();
         		}
     
            }        	
        });
        
		// Creates Window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(600, 500);
        frame.setVisible(true);
	}

}
