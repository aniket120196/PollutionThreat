/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.mysql.jdbc.*;
import java.io.BufferedReader;
import java.io.File;
import java.sql.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.ServletContext;
import java.lang.UnsupportedOperationException;   
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;



/**
 *
 * @author jemi java
 */
public class Encrypt {
  public static void main(String[] args)  {  
   
  }
  
  public void fun(String u,String n,String key)
  {
      
      
      Statement   st;
       try {
           int i=0;
                        
                        String fname=n;
                        String full_path=u;
                        
                         String content=u;
//                         String imagepart=image;
                          String s="Not Set";
                            String ss="Null",usn="Admin";  
//Folder changes 2 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                           
                        //String out_put_path="C:/Cloud_Project/"+n;
                        String out_put_path="D:/image/encrypt/"+n;
 //MODIFICATION 1                    
//                      String out_put_path1="D:/file/EUpload1/"+n;
//MODIFICATION 1
//Folder changes 2 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                           
                             
 //MODIFICATION 1...         
                           
		//	String key = "squirrel123"; // needs to be at least 8 characters for DES
//                      FileInputStream fis1 = new FileInputStream(full_path);
//			FileOutputStream fos1 = new FileOutputStream(out_put_path1);
//			encrypt(key, fis1, fos1);
                        
 //MODIFICATION 1 END...                       

			FileInputStream fis = new FileInputStream(full_path);
			FileOutputStream fos = new FileOutputStream(out_put_path);
			encrypt(key, fis, fos);
                         

                        
                        
                                   try
            {
                i++;
               
      BufferedReader br = new BufferedReader(new FileReader(out_put_path));
      String encrypt=br.readLine();
//      JOptionPane.showMessageDialog(null, encrypt);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                
                String on="update key1 set key1='"+key+"'  encryptFilePath='"+out_put_path+"' ,encryptFileContent='"+encrypt+"'where  fileName='"+fname+"'";
                PreparedStatement ps=con.prepareStatement(on);
              
               
                          
                int r=ps.executeUpdate();
                if(r!=0)
                {                    
//                 JOptionPane.showMessageDialog(null, );
                 System.out.print("Send successfully");
                }
                else
                {
                 JOptionPane.showMessageDialog(null, "Send falied");
                }
            } 

             catch(Exception e1)
             {
                 System.out.println(e1);
             }    
                        
                        
                        
     
            
                        {
                            
                        }

		} catch (Throwable e) {
                    System.out.println(e);
			e.printStackTrace();
		}
  }
            public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
	}

	public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
	}

	public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == Cipher.DECRYPT_MODE) {  
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}
	}
           public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}

    
}



