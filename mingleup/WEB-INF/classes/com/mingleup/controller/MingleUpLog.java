
package com.mingleup.controller;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MingleUpLog {
	
	protected static String logFile = "/home/ubuntu/Desktop/mingleup.txt";
	private static org.apache.log4j.Logger log = Logger.getLogger(MingleUpLog.class);
	private static Object appender;
	//private Logger logger = null;
	
	public void init() {
		log = Logger.getRootLogger();
		BasicConfigurator.configure();
		
	}
		 public static void write(String username) throws IOException {
	         write(logFile, username);
	     }
	    
	    public static void write(String logFile, String username) throws IOException {
	         TimeZone tZone = TimeZone.getTimeZone("IST"); // or PST, MID, etc ...
	         Date date = new Date();
	         DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         dFormat.setTimeZone(tZone);
	         String currentTime = dFormat.format(date);
	         
	         FileWriter fWriter = new FileWriter(logFile, true);
	         fWriter.write(currentTime + " " + username + "\n");
	         
	         //AddressBookLog.appender.DatePattern='yyyy-MM-dd';
	         fWriter.flush();
	         fWriter.close();
	     }
}
