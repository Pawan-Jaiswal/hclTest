//program to download file

package com.pr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

class Practice 
{ 
	public Practice() {  
    }
	
	public static void main(String args[]) 
	 {
		String SFTPHOST = "dewdfms0058.wdf.sap.corp";    // won't connect here
        int    SFTPPORT = 22;  
        String SFTPUSER = "userName";  
        String passphrase = "passphrase"; 
        String SFTPWORKINGDIR = "remote directory";    
        String prikeyfile = "C:\\Users\\c5292542\\.ssh\\id_rsa";


        Session     session     = null;  
        Channel     channel     = null;  
        ChannelSftp channelSftp = null;  

try{  
        JSch jsch = new JSch();  
        jsch.addIdentity(prikeyfile, passphrase);
        session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);  
        session.setConfig("StrictHostKeyChecking", "no"); 
        session.connect();  
        channel = session.openChannel("sftp");  
        channel.connect();  
        channelSftp = (ChannelSftp)channel;  
        channelSftp.cd(SFTPWORKINGDIR);  
        byte[] buffer = new byte[1024];  
        BufferedInputStream bis = new BufferedInputStream(channelSftp.get("file.csv"));  
        File newFile = new File("C:\\file.csv"); 
        OutputStream os = new FileOutputStream(newFile);  
        BufferedOutputStream bos = new BufferedOutputStream(os);  
        int readCount;  

while( (readCount = bis.read(buffer)) > 0)
       {  
        System.out.println("Writing files to disk: " );  
        bos.write(buffer, 0, readCount);  
       }  
        bis.close();  
        bos.close();  
        }catch(Exception ex){  
        ex.printStackTrace();  

        }  

    }      
 }
   
