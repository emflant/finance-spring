package com.emflant.accounting.main.component;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.emflant.common.EntLogger;

public class EntJTable extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	private List<EntTableHeader> tableHeaders;
	
	public EntJTable(){
		this.tableHeaders = new ArrayList<EntTableHeader>(20);
		this.setFocusable(false);
	}
	
	
	
	public void entAddTableHeader(EntTableHeader entTableHeader){
		this.tableHeaders.add(entTableHeader);
	}
	
	public void entAddTableHeader(String identifier, String headerValue, int align, int width){
		this.tableHeaders.add(new EntTableHeader(identifier, headerValue, align, width));
	}
	
	public void entAddCheckBoxTableHeader(String identifier, String headerValue, int align, int width){
		this.tableHeaders.add(new EntTableHeader(identifier, headerValue, align, width));
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
			EntLogger.error("테이블정보에 "+identifier+" 필드가 존재하지 않습니다.");
			return null;
		}
		return (String)dtm.getValueAt(selectedRow, nResult);
	}
	
	

	private TableColumnModel getTableColumnModel(DefaultTableModel model, List<EntTableHeader> tableHeader){
		
		TableColumnModel tableColumnModel = new DefaultTableColumnModel();

		for(EntTableHeader column : tableHeader){
			
			int nIndex = model.findColumn(column.getIdentifier());
			if(nIndex == -1){
				EntLogger.error("테이블정보에 "+column.getIdentifier()+" 필드가 존재하지 않습니다.");
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
}
