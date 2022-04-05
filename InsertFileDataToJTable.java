import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class InsertFileDataToJTable extends AbstractTableModel {
	
	// Vectors
	Vector data;
	Vector columns;
	
	// Strings
	String appFile;
	
	// Stream
	FileInputStream fis;
	BufferedReader br;
	StringTokenizer st1;

	public InsertFileDataToJTable() {
		appFile = new String("AppStackApps.txt");
		String line;
		data = new Vector();
		columns = new Vector();
		
		try {
			fis = new FileInputStream(appFile);
			br = new BufferedReader(new InputStreamReader(fis));
			st1 = new StringTokenizer(br.readLine(), ",");
			
			
			while (st1.hasMoreTokens()) {
				columns.addElement(st1.nextToken());
			}
			
			while ((line = br.readLine()) != null) {
				StringTokenizer st2 = new StringTokenizer(line, ",");
				while (st2.hasMoreTokens())
					data.addElement(st2.nextToken());
			}
			
		
            
			
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		return data.size() / getColumnCount();
	}

	public int getColumnCount() {
		return columns.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return (String) data.elementAt((rowIndex * getColumnCount())
				+ columnIndex);
	}
	
	


}