import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AppCatalogPage extends JFrame {
	public AppCatalogPage() {
		JFrame frame = new JFrame("AppStack");
		
		String appFile = new String("AppStackApps.txt");
		
		// Search box
		JTextArea result = new JTextArea(30, 50);
		result.setEditable(false);
		
		JPanel searchPanel = new JPanel();
		JScrollBar scrollBar = new JScrollBar();
		JScrollPane scrollPane = new JScrollPane(result);
		JTextField searching = new JTextField(30);
		
		JTable searchTable = new JTable();
		
		JButton searchB = new JButton("Search");
		ArrayList<String> historyList = new ArrayList<String>();


		InsertFileDataToJTable model = new InsertFileDataToJTable();
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		JTable table = new JTable(model);
		table.setRowSorter(sorter);
		table.getColumnModel().getColumn(0).setHeaderValue("App");
		table.getColumnModel().getColumn(1).setHeaderValue("Publisher");
		table.getColumnModel().getColumn(2).setHeaderValue("Platform");
		table.getColumnModel().getColumn(3).setHeaderValue("Version");
		table.getColumnModel().getColumn(4).setHeaderValue("Link");
		table.getColumnModel().getColumn(5).setHeaderValue("Price");
		

		searchB.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 try {	
            		 
            		String searchMade = searching.getText().trim();
            		historyList.add(searchMade);
            		
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
		
		
		JButton searchHistoryB = new JButton("Search History");
		searchHistoryB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           	 try {	
           		SearchHistory searches = new SearchHistory(historyList);
        		
        		
        		} catch (Exception f) {
        			f.printStackTrace();
        		}
            }
        });

		
		int[] rowIndex = table.getSelectedRows();
		int[] colIndex = table.getSelectedColumns();
		
		// Filter function
		JButton filterCrossBtn = new JButton("Cross-platform Apps Only");
		filterCrossBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
           		 
            		String platform = "cross-platform";
            			
            		RowFilter<TableModel, Object> rf = null;
            	    //If current expression doesn't parse, don't update.
            	    try {
            	        rf = RowFilter.regexFilter(platform, 0);
            	    } catch (java.util.regex.PatternSyntaxException f) {
            	    	
            	        return;
            	    }
            	    sorter.setRowFilter(rf);
     	            sorter.setRowFilter(RowFilter.regexFilter(platform));

            		
         		} catch (Exception f) {
         			f.printStackTrace();
         		}
			}
		});
		
		JButton filterMobileBtn = new JButton("Mobile Apps Only");
		filterMobileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
           		 
            		String platform = "mobile";
            			
            		RowFilter<TableModel, Object> rf = null;
            	    //If current expression doesn't parse, don't update.
            	    try {
            	        rf = RowFilter.regexFilter(platform, 0);
            	    } catch (java.util.regex.PatternSyntaxException f) {
            	    	
            	        return;
            	    }
            	    sorter.setRowFilter(rf);
     	            sorter.setRowFilter(RowFilter.regexFilter(platform));

            		
         		} catch (Exception f) {
         			f.printStackTrace();
         		}
			}
		});
		
		
		JButton filterFree= new JButton("Free Apps Only");
		filterFree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
           		 
            		String price = "0.0";
            			
            		RowFilter<TableModel, Object> rf = null;
            	    //If current expression doesn't parse, don't update.
            	    try {
            	        rf = RowFilter.regexFilter(price, 0);
            	    } catch (java.util.regex.PatternSyntaxException f) {
            	    	
            	        return;
            	    }
            	    sorter.setRowFilter(rf);
     	            sorter.setRowFilter(RowFilter.regexFilter(price));

            		
         		} catch (Exception f) {
         			f.printStackTrace();
         		}
			}
		});
		
		JButton filterClear = new JButton("Clear Filters");
		filterClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
           		 
            		String platform = "";
            			
            		RowFilter<TableModel, Object> rf = null;
            	    //If current expression doesn't parse, don't update.
            	    try {
            	        rf = RowFilter.regexFilter(platform, 0);
            	    } catch (java.util.regex.PatternSyntaxException f) {
            	    	
            	        return;
            	    }
            	    sorter.setRowFilter(rf);
     	            sorter.setRowFilter(RowFilter.regexFilter(platform));

            		
         		} catch (Exception f) {
         			f.printStackTrace();
         		}
			}
		});
		
		searchPanel.add(filterCrossBtn, BorderLayout.SOUTH);
		searchPanel.add(filterMobileBtn, BorderLayout.SOUTH);
		searchPanel.add(filterFree, BorderLayout.SOUTH);
		searchPanel.add(filterClear, BorderLayout.SOUTH);
		
	
		// Search box		
		JPanel reviewPanel = new JPanel();
		reviewPanel.setSize(600, 500);
		
		// Username
		JButton displayReview = new JButton("Reviews");
		reviewPanel.add(displayReview);
		displayReview.setMnemonic(KeyEvent.VK_C);
	    displayReview.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		int[] selectedRows= table.getSelectedRows();
	    		int[] selectedColumns = table.getSelectedColumns();
	    		String reviewText = "";
	    		String reviewsName = (table.getValueAt(selectedRows[0], 0)) + "Reviews.txt";
	    		try {
	    			Scanner fin = new Scanner(new File(reviewsName));
	    			while(fin.hasNext()) {
         				String currentLine = fin.nextLine();
         				String[] arr = currentLine.split("//");
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
		
		
		// JTable
		
		table.setRowHeight(30);
		//table.setRowHeight(10, 50);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(600, 500));
		
		// Panel
		searchPanel.setSize(600, 500);
		searchPanel.add(scrollpane);
		searchPanel.add(searching, BorderLayout.SOUTH);
		searchPanel.add(searchHistoryB, BorderLayout.SOUTH);
		searchPanel.add(searchB, BorderLayout.SOUTH);
		//searchPanel.add(scrollPane, BorderLayout.SOUTH);
		//searchPanel.add(scrollBar);
		//searchPanel.add(displayReview, BorderLayout.SOUTH);
		//searchPanel.add(displayDesc, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(searchPanel);
        frame.setSize(1000, 700);
        frame.setVisible(true);
		
        JButton displayBtn = new JButton("Display");
        searchPanel.add(displayBtn);
        displayBtn.setMnemonic(KeyEvent.VK_C);
	    displayBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		int[] selectedRows= table.getSelectedRows();
	    		//int[] selectedColumns = table.getSelectedColumns();
	    		String reviewText = "";
	    		String displayApp = (table.getValueAt(selectedRows[0], 0)) + "";
	    		AppPage app = new AppPage(displayApp);
	    	    
	    	}
	    });
    	
	}
	
}
