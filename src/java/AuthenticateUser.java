/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kahilan
 */
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxFileInfo;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxServerException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.RequestTokenPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramesh
 */
//timebasedgroupkey----timebasedgroupkey123
public class AuthenticateUser {

//
//    private static final String APP_KEY = "8v421yst4xtt6zm"; 
//    private static final String APP_SECRET = "rtha8nuwaj877xa"; 
//    
    
    private static final String APP_KEY = "k3pdh35572mj12v";
 
    private static final String APP_SECRET = "31tgtaquxf9qhdc"; 

    
    
    
    private static final AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
    private static DropboxAPI mDBApi;

    public static void main() {
        try {
            AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
            WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);
            WebAuthInfo authInfo = session.getAuthInfo();
            RequestTokenPair pair = authInfo.requestTokenPair;
            String url = authInfo.url;

            System.out.println("URL Value"+authInfo.url);
        
            try {
                try {
                    Desktop.getDesktop().browse(new URL(url).toURI());
                } catch (URISyntaxException ex) {
                    Logger.getLogger(AuthenticateUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(AuthenticateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Press ok to continue once you have authenticated.");
            session.retrieveWebAccessToken(pair);
            AccessTokenPair tokens = session.getAccessTokenPair();
            System.out.println("Access granted");
            mDBApi = new DropboxAPI(session);


        } catch (DropboxException ex) {
            Logger.getLogger(AuthenticateUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void upload(File f,String location) throws FileNotFoundException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            mDBApi.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
        }
        catch (DropboxException ex) {
            Logger.getLogger(AuthenticateUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(AuthenticateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static File download(String location,String fileName) throws FileNotFoundException, DropboxException {

        File file = null;
        FileOutputStream outputStream = null;
        try {
             file = new File("D:\\file\\ThirdpartyEupload\\1",fileName);
             
            outputStream = new FileOutputStream(file);
         DropboxFileInfo info=mDBApi.getFile("/"+location+"/"+fileName, null, outputStream, null);
        System.out.println(info);
        }catch(DropboxServerException dse){
            int status=dse.error;
            System.out.println(status);
            if(status==404){
                
             //   download("XOR",fileName);
            }
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(AuthenticateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return file;
    }
}
