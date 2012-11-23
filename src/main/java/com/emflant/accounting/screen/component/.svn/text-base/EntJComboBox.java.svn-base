package com.emflant.accounting.main.component;

import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.emflant.accounting.dto.table.CodeDetailDTO;
import com.emflant.common.EntHashList;
import com.emflant.common.EntLogger;

public class EntJComboBox extends JComboBox {
	
	private EntHashList entHashList;
	
	public EntJComboBox(){
		
		//KeyListener[] list = this.getAncestorListeners();
		//EntLogger.debug("count : "+this.getAncestorListeners().length);
		
		//EntLogger.debug("count : "+this.getKeyListeners().length);
		this.addKeyListener(new EntJComboBoxKeyListener(this));
		//EntLogger.debug("count : "+this.getKeyListeners().length);
	}
	public void entSetEntHashList(EntHashList entHashList){
		this.entHashList = entHashList;
		DefaultComboBoxModel dcbm = new DefaultComboBoxModel(this.entHashList.getList().toArray());
		this.setModel(dcbm);
	}
	public String entGetCodeOfSelectedItem(){
		return this.entHashList.getCodeBySelectedIndex(this.getSelectedIndex());
	}
	public String entGetCodeNameOfSelectedItem(){
		return this.entHashList.getCodeNameBySelectedIndex(this.getSelectedIndex());
	}
	
	public void entSetSelectedItemByCode(String code){
		this.setSelectedItem(this.entHashList.getCodeDetail(code));
	}
	
	public List<CodeDetailDTO> getCodeDetailList(){
		return this.entHashList.getList();
	}
}
