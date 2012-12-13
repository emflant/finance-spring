package com.emflant.accounting.screen.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.log4j.Logger;


public class EntJTable extends JTable {
	
	private static final Logger logger = Logger.getLogger(EntJTable.class);
	
	private static final long serialVersionUID = 1L;
	
	private List<EntTableHeader> tableHeaders;
	private TableColumnModel tableColumnModel;
	
	public EntJTable(){
		this.tableHeaders = new ArrayList<EntTableHeader>(20);
		this.setFocusable(false);
		this.tableColumnModel = new DefaultTableColumnModel();
		this.setColumnModel(tableColumnModel);
	}
	
	
	public void entAddTableHeader(String identifier, String headerValue, int align, int width){
		this.tableHeaders.add(new EntTableHeader(identifier, headerValue, align, width));
		
		TableColumn tableColumn = new TableColumn();
		tableColumn.setIdentifier(identifier);
		tableColumn.setHeaderValue(headerValue);
		tableColumn.setPreferredWidth(width);
		
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(align);
		tableColumn.setCellRenderer(defaultTableCellRenderer);
		
		this.tableColumnModel.addColumn(tableColumn);
		
	}
	
	public void entAddCheckBoxTableHeader(String identifier, String headerValue, int align, int width){
		this.tableHeaders.add(new EntTableHeader(identifier, headerValue, align, width));
	}
	
	public void entSetTableModel(List list){
		this.entSetTableModel(convert(list));
	}
	
	public void entSetTableModel(DefaultTableModel model){
		this.setModel(model);
		this.setColumnModel(getTableColumnModel(model, this.tableHeaders));
	}
	
	public String entGetValueOfSelectedRow(String identifier){
		return entGetValueOfSelectedRow(this.getSelectedRow(), identifier);
	}
	
	public String entGetValueOfSelectedRow(int selectedRow, String identifier){
		
		DefaultTableModel dtm = (DefaultTableModel)this.getModel();
		int nResult = dtm.findColumn(identifier);
		
		if(nResult == -1){
			//EntLogger.error(identifier+" does not exist.");
			return null;
		}
		return (String)dtm.getValueAt(selectedRow, nResult);
	}
	
	

	private TableColumnModel getTableColumnModel(DefaultTableModel model, List<EntTableHeader> tableHeader){
		
		TableColumnModel tableColumnModel = new DefaultTableColumnModel();

		for(EntTableHeader column : tableHeader){
			
			int nIndex = model.findColumn(column.getIdentifier());
			if(nIndex == -1){
				//EntLogger.error("error : "+column.getIdentifier());
				continue;
			}
			
			TableColumn tableColumn = new TableColumn(nIndex);
			tableColumn.setIdentifier(column.getIdentifier());
			tableColumn.setHeaderValue(column.getHeaderValue());
			tableColumn.setPreferredWidth(column.getWidth());

			
			DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
			defaultTableCellRenderer.setHorizontalAlignment(column.getAlign());
			tableColumn.setCellRenderer(defaultTableCellRenderer);
			
			
			tableColumnModel.addColumn(tableColumn);
			
		}

		return tableColumnModel;
	}
	

	
	private DefaultTableModel convert(List list){
		
		DefaultTableModel tmResult = new DefaultTableModel();
		
		if(list.isEmpty()){
			return tmResult;
		}
		
		HashMap hm = (HashMap)list.get(0);
		
		int nColumnCnt = hm.size();
		String[] columns = new String[nColumnCnt];
		
		Iterator<String> iter = hm.keySet().iterator();
		
		int k=0;
		
		while(iter.hasNext()){
			String key = iter.next();
			columns[k] = key;
			k++;
		}
		
		tmResult.setColumnIdentifiers(columns);
		
		Object[] row = null;
		
	    for(int i=0;i<list.size();i++){
	    	
	    	hm = (HashMap)list.get(i);
	    	
	    	row = new String[nColumnCnt];

	    	for(int j=0;j<nColumnCnt;j++){
	    		
	    		row[j] = ""+hm.get(columns[j]);
	    	}
	    	
	    	tmResult.addRow(row);
	    	
	    }
		
		return tmResult;
	}
}
