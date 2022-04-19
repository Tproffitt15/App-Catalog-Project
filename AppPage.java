import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultCaret;

public class AppPage extends JFrame {
	public AppPage(String appName) {
		JFrame frame = new JFrame(appName);
		JPanel panel = new JPanel();
		frame.add(panel);
		       
		JPanel disPanel = new JPanel();
		
        ImageIcon appIcon = new ImageIcon(appName + ".jpg");
        Image image = appIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        appIcon.setImage(newimg);

        JLabel appLogo = new JLabel(appIcon);

        panel.add(appLogo);
        
        JButton descBut = new JButton("Description");
        panel.add(descBut);
        JButton reviewBut = new JButton("Reviews");
        panel.add(reviewBut);
        JButton addReviewBut = new JButton("Add Review");
        panel.add(addReviewBut);
        
        JTextArea area = new JTextArea(20, 55);
        //area.setBounds(5,5,100,200);
        area.setEditable(false);
        area.setVisible(true);
        //area.setBounds (50, 100, 500, 300);
        
        JScrollPane scrollPane = new JScrollPane(area);
        DefaultCaret caret = (DefaultCaret) area.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
 
        disPanel.add(scrollPane);
        //scrollPane.setBounds(3,3,400,400);
        //frame.getContentPane().add(area);
       
        
        
        descBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
           		 	// creates a new scanner from the text file of apps
                    String appFile = new String(appName + ".txt");
        			Scanner fin = new Scanner(new File(appFile));
        			String desc = "";
        			while(fin.hasNext()) {
        				desc += fin.nextLine() + "\n";
        			}
        			area.setText(desc);
        			
            		
            	} catch (Exception f) {
         			f.printStackTrace();
         		}
     
            }
        });
        ;
        
        reviewBut.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	try {
           		 	// creates a new scanner from the text file of apps
            		String appFile = new String(appName + "Reviews" + ".txt");
            		
        			Scanner fin = new Scanner(new File(appFile));
        			String desc = "";
        			while(fin.hasNext()) {
        				desc += fin.nextLine() + "\n";
        			}
        			area.setText(desc);
        			
            		
            	} catch (Exception f) {
         			f.printStackTrace();
         		}
     
            }        	
        });

        addReviewBut.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		AppReviewPage reviewPage = new AppReviewPage(appName);
        		
            }        	
        });
        
		// Creates Window
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(disPanel);
        frame.setSize(600, 500);
        frame.setVisible(true);
	}

}
