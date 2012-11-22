package com.emflant.accounting.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author home
 * @version 1.0
 * @created 22-2-2011 ���� 1:31:43
 */
public class EntDate {
	
	private Date date;
	private String strDate;

	public EntDate(String date){
		this.strDate = date;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String getTodayDateTimeMillis(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
	
	
	public static String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
	
	@Deprecated
	static String getTimeMillis(){
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
		return sdf.format(new Date());
	}
	
	/**
	 * ����ֱ�
	 * 
	 * @param toDate
	 */
	public int betweenDate(EntDate toDate){
		return (int)((toDate.getDate().getTime() - date.getTime())/1000/60/60/24);
	}
	
	public static String addMonth(String strDate, int nMonth){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String result = null;
		
		try {
			Date date = sdf.parse(strDate);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, nMonth);
			
			result = sdf.format(calendar.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int betweenDate(String fromDate, String toDate){
		return 0;
	}
	
	public String toString(){
		return this.strDate;
	}
	
	public Date getDate(){
		return date;
	}
	
	public int compareTo(EntDate baseDate){
		return strDate.compareTo(baseDate.toString());
	}
	
}