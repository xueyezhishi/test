package test;

import java.math.BigDecimal;
import java.net.*;  
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.*;  



  
public class test2 {  
    public static void main(String[] args) throws Exception {  
		try {
/*			Date time = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date value = sdf.parse(time.toString());
			System.out.println(value);*/
			
			   Date currentTime = new Date();
			   SimpleDateFormat formatter = new SimpleDateFormat("MM.dd");
			   String dateString = formatter.format(currentTime);

			System.out.println(dateString);
		} catch (Exception e) {
			System.out.println("##2##");
			e.printStackTrace();
		}
    }  
}  