
import Cloudme.CloudmeUser;
import javax.swing.JOptionPane;

/**
 *
 * @author ANAGAN
 */
public class cloudme {
     void cloud1(String[] args) throws Exception {        
           String[] s=args;   
           String ss=s[0].toString();
           String path = "D:\\image\\encrypt\\"+ss;
          // D:\image\encrypt
//           String path = "D:\\file\\ccaf\\encrypt file\\"+ss;
try{
        CloudmeUser user=new CloudmeUser("ccaf","ccaf123");
         user.getFileManager().uploadFile(path,"/Personaldetailsed/");
         user.killUser();}
catch(Exception e)
         {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, e);
         }
     }
}