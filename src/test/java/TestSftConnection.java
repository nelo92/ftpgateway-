import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class TestSftConnection {
	
	public static final String REMOTE_FILE = Constants.SERVEUR_DIONYSOS_REMOTE_DIRECTORY + "remotefile.txt";
	
	public static void showFile() {
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(Constants.SERVEUR_DIONYSOS_USER, Constants.SERVEUR_DIONYSOS_HOST, Constants.SERVEUR_DIONYSOS_PORT);
			session.setPassword(Constants.SERVEUR_DIONYSOS_PWD);
//			session.setConfig("StrictHostKeyChecking", "no");
			java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.setConfig(config);
//			session.setProxy(new ProxySOCKS5(Constants.PROXY_HOST, Constants.PROXY_PORT));
			System.out.println("Establishing Connection...");
			session.connect();
			System.out.println("Connection established.");
			System.out.println("Creating SFTP Channel.");
			ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
			sftpChannel.connect();
			System.out.println("SFTP Channel created.");

			InputStream out = null;
			out = sftpChannel.get(REMOTE_FILE);
			BufferedReader br = new BufferedReader(new InputStreamReader(out));
			String line;
			while ((line = br.readLine()) != null)
				System.out.println(line);
			br.close();
						
		} catch (Exception e) { System.err.print(e); }
	}

	public static void downloadFile() {
		
      JSch jsch = new JSch();
      Session session = null;
      System.out.println("TestSftConnection...");
      try {
      	System.out.println("session.connect...");
          session = jsch.getSession(Constants.SERVEUR_DIONYSOS_USER, Constants.SERVEUR_DIONYSOS_HOST, Constants.SERVEUR_DIONYSOS_PORT);
          session.setPassword(Constants.SERVEUR_DIONYSOS_PWD);                   
          session.setConfig("StrictHostKeyChecking", "no");
          System.out.println("Establishing Connection...");
          session.connect();
          System.out.println("session.connect.");
          System.out.println("channel connect...");
          Channel channel = session.openChannel("sftp");            
          channel.setInputStream(System.in);
          channel.setOutputStream(System.out);            
          channel.connect();           
          System.out.println("channel connect.");
          
          ChannelSftp sftpChannel = (ChannelSftp) channel;
          sftpChannel.get(REMOTE_FILE, "localfile.txt");
          sftpChannel.exit();
          session.disconnect();
      } catch (JSchException e) {
          e.printStackTrace();  
      } catch (SftpException e) {
          e.printStackTrace();
      }
      System.out.println("TestSftConnection.");
	}
	
	public static void uploadFile() {		
	}
	
	public static void main(String args[]) {		
		showFile();
	
    }
}
