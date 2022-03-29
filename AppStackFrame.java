import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.*;

/**
 * Java class called AppStackFrame that extends JFrame. 
 * Displays a graphical user interface. It adds the AppStackPanel to itself. 
 * @author Troy Proffitt, Darcy Hayes, Anna Martin, Clark Seese
 */

public class AppStackFrame extends JFrame {
	
	public static final int SCREEN_WIDTH = 1_000;
    public static final int SCREEN_HEIGHT = 1_000;

	public AppStackFrame() {
		this.setTitle("AppStack");
		this.add(new AppStackPanel());
		this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);		

	}
}
