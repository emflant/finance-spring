package com.emflant.accounting.screen.component;

class EntTableHeader {
	
	private String component;
	private String identifier;
	private String headerValue;
	private int align;
	private int width;
	
	
	public EntTableHeader(String identifier, String headerValue, int align){
		this(identifier, headerValue, align, 100);
	}
	
	public EntTableHeader(String component, String identifier, String headerValue, int align, int width){
		this(identifier, headerValue, align, width);
		this.component = component;
	}
	
	public EntTableHeader(String identifier, String headerValue, int align, int width){
		this.identifier = identifier;
		this.headerValue = headerValue;
		this.align = align;
		this.width = width;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getHeaderValue() {
		return headerValue;
	}
	public void setHeaderValue(String headerValue) {
		this.headerValue = headerValue;
	}
	public int getAlign() {
		return align;
	}
	public void setAlign(int align) {
		this.align = align;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	

}
