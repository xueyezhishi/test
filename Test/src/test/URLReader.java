package test;  
import java.net.*;  
import java.io.*;  
  
public class URLReader {  
    public static void main(String[] args) throws Exception {  
    URL yahoo = new URL("http://yuntuapi.amap.com/datamanage/data/list?tableid=580dcc1e305a2a4ab55e450a&key=7de94194f6680b13d017e00c09276bc3");  
    BufferedReader in = new BufferedReader(  
                new InputStreamReader(  
                yahoo.openStream()));  
  
    String inputLine;  
  
    while ((inputLine = in.readLine()) != null)  
        System.out.println(inputLine);  
  
    in.close();  
    }  
}  