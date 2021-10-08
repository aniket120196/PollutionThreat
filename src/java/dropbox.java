/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.dropbox.client2.exception.DropboxException;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author ANAGAN
 */
public class dropbox {
     void cloud1(String[] path) throws DropboxException {
         try
         {
                               String[] s=path;   
                               String ss=s[0].toString();
                                AuthenticateUser.main();
                                File inputFile1 = new File("D:\\image\\encrypt\\"+ss);
                                 AuthenticateUser.upload(inputFile1, "tamil");
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }
         
     }
    
}
