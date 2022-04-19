import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

public class SearchHistory extends JFrame {
	public SearchHistory(ArrayList<String> searchHistory) {
		JFrame frame = new JFrame("Search History");
		JPanel panel = new JPanel();
		frame.add(panel);
		       
		JLabel label = new JLabel("Search History");
		label.setFont(new Font("Serif", Font.PLAIN, 35));
        panel.add(label);
		
        JTextArea area = new JTextArea("");
        area.setEditable(false);
        area.setBounds (50, 100, 500, 300);
        
        JScrollPane scrollPane = new JScrollPane(area);


        frame.add(area, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.SOUTH);
        
        String desc = "";
        int length = searchHistory.size();
        for(int i = 0; length > 0; i++) {
			desc += searchHistory.get(i) + "\n";
			length = length - 1;
		}
		area.setText(desc);

        
        frame.add(panel);
        frame.setSize(600, 500);
        frame.setVisible(true);
	}

}

