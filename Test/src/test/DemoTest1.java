package test;  
  
import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.net.URL;  
import java.net.URLEncoder;  
  
public class DemoTest1 {  
  
    public static final String GET_URL = "http://yuntuapi.amap.com/datamanage/data/list?tableid=580dcc1e305a2a4ab55e450a&key=7de94194f6680b13d017e00c09276bc3";  
//    public static final String POST_URL = "http://112.4.27.9/mall-back/if_user/store_list";  
    // ����Խӿ�  
    public static final String POST_URL = "http://yuntuapi.amap.com/datamanage/data/list?";  
      
    /** 
     * �ӿڵ��� GET 
     */  
    public static void httpURLConectionGET() {  
        try {  
            URL url = new URL(GET_URL);    // ���ַ���ת��ΪURL�����ַ  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// ������  
            connection.connect();// ���ӻỰ  
            // ��ȡ������  
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  
            String line;  
            StringBuilder sb = new StringBuilder();  
            while ((line = br.readLine()) != null) {// ѭ����ȡ��  
                sb.append(line);  
            }  
            br.close();// �ر���  
            connection.disconnect();// �Ͽ�����  
            System.out.println(sb.toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("ʧ��!");  
        }  
    }  
      
    /** 
     * �ӿڵ���  POST 
     */  
    public static void httpURLConnectionPOST () {  
        try {  
            URL url = new URL(POST_URL);  
              
            // ��url �� open�������ص�urlConnection  ����ǿתΪHttpURLConnection����  (��ʶһ��url�����õ�Զ�̶�������)  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// ��ʱcnnectionֻ��Ϊһ�����Ӷ���,��������  
              
            // �������������Ϊtrue,Ĭ��false (post �����������ķ�ʽ��ʽ�Ĵ��ݲ���)  
            connection.setDoOutput(true);  
              
            // ��������������Ϊtrue  
            connection.setDoInput(true);  
              
            // ��������ʽΪpost  
            connection.setRequestMethod("POST");  
              
            // post���󻺴���Ϊfalse  
            connection.setUseCaches(false);  
              
            // ���ø�HttpURLConnectionʵ���Ƿ��Զ�ִ���ض���  
            connection.setInstanceFollowRedirects(true);  
              
            // ��������ͷ����ĸ������� (����Ϊ�������ݵ�����,����Ϊ����urlEncoded�������from����)  
            // application/x-javascript text/xml->xml���� application/x-javascript->json���� application/x-www-form-urlencoded->������  
            // ;charset=utf-8 ����Ҫ����Ȼ��Ǳ߻�������롾�����  
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");     
              
            // �������� (����δ��ʼ,ֱ��connection.getInputStream()��������ʱ�ŷ���,���ϸ��������������ڴ˷���֮ǰ����)  
            connection.connect();  
              
            // �������������,�����������������Я���Ĳ���,(�������Ϊ?���������)  
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());  
              
            String app_key = "app_key="+ URLEncoder.encode("4f7bf8c8260124e6e9c6bf094951a111", "utf-8");        // ���޸ġ���Ϊ�������ݣ�������Ϣй¶��  
            String agt_num = "&agt_num="+ URLEncoder.encode("10111", "utf-8");              // ���޸ġ���Ϊ�������ݣ�������Ϣй¶��  
            String pid = "&pid="+ URLEncoder.encode("BLZXA150401111", "utf-8");             // ���޸ġ���Ϊ�������ݣ�������Ϣй¶��  
            String departid = "&departid="+ URLEncoder.encode("10007111", "utf-8");         // ���޸ġ���Ϊ�������ݣ�������Ϣй¶��  
            String install_lock_name = "&install_lock_name="+ URLEncoder.encode("�������", "utf-8");  
            String install_address = "&install_address="+ URLEncoder.encode("��������", "utf-8");  
            String install_gps = "&install_gps="+ URLEncoder.encode("116.350888,40.011001", "utf-8");  
            String install_work = "&install_work="+ URLEncoder.encode("С��", "utf-8");  
            String install_telete = "&install_telete="+ URLEncoder.encode("13000000000", "utf-8");  
            String intall_comm = "&intall_comm="+ URLEncoder.encode("һ������", "utf-8");  
              
            // ��ʽ parm = aaa=111&bbb=222&ccc=333&ddd=444  
            String parm = app_key+ agt_num+ pid+ departid+ install_lock_name+ install_address+ install_gps+ install_work+ install_telete+ intall_comm;  
              
/*            String tableid = "tableid=580dcc1e305a2a4ab55e450a";
            String key = "&key=7de94194f6680b13d017e00c09276bc3";
            String filter = "&filter=_name:�㽭";
            String parm = tableid + key + filter;*/
            // ���������������  
            dataout.writeBytes(parm);  
              
            // �����ɺ�ˢ�²��ر���  
            dataout.flush();  
            dataout.close(); // ��Ҫ���׺��Բ��� (�ر���,�м�!)   
              
//            System.out.println(connection.getResponseCode());  
              
            // ���ӷ�������,�����������Ӧ  (�����ӻ�ȡ������������װΪbufferedReader)  
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
            String line;  
            StringBuilder sb = new StringBuilder(); // �����洢��Ӧ����  
              
            // ѭ����ȡ��,��������β��  
            while ((line = bf.readLine()) != null) {  
//                sb.append(bf.readLine());  
                sb.append(line).append(System.getProperty("line.separator"));  
            }  
            bf.close();    // ��Ҫ���׺��Բ��� (�ر���,�м�!)   
            connection.disconnect(); // ��������  
            System.out.println(sb.toString());  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void main(String[] args) {  
   //     httpURLConectionGET();  
        httpURLConnectionPOST();  
    }  
}