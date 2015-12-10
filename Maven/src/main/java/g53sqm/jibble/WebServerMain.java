package g53sqm.jibble;
/* 
Copyright Paul James Mutton, 2001-2004, http://www.jibble.org/

This file is part of Jibble Web Server / WebServerLite.

This software is dual-licensed, allowing you to choose between the GNU
General Public License (GPL) and the www.jibble.org Commercial License.
Since the GPL may be too restrictive for use in a proprietary application,
a commercial license is also provided. Full license information can be
found at http://www.jibble.org/licenses/

$Author: pjm2 $
$Id: WebServerMain.java,v 1.2 2004/02/01 13:37:35 pjm2 Exp $

*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.Scanner;

import org.slf4j.*;

/**
 * This class contains the main method for the Jibble Web Server.
 * 
 * @author Copyright Paul Mutton, http://www.jibble.org/
 */
public class WebServerMain {
	
	static org.slf4j.Logger Logger = LoggerFactory.getLogger(WebServerMain.class);

    public static void main(String[] args) throws IOException {
        
        String rootDir = WebServerConfig.DEFAULT_ROOT_DIRECTORY;
        int port = WebServerConfig.DEFAULT_PORT;
        File file = new File(rootDir);
        file = file.getCanonicalFile();
        
        System.out.println("Jibble web server (modified by Chan Chang Wei 010761 for G53SQM)");
        System.out.println("Root Directory:" + file);
        System.out.println("Port:" + port);
        Logger.info("Log Information");
        
        try(FileReader reader = new FileReader("config")){
        	Properties properties = new Properties();
        	properties.load(reader);
        	
        	Scanner in = new Scanner(System.in);
        	
        	System.out.println("Root Directory : ");
        	String rootDirInput = in.nextLine();
        	properties.setProperty(rootDirInput, rootDir);
        	
            System.out.println("Root Directory : " + properties.getProperty("rootDir1"));
            System.out.println("CGI-BIN : " + properties.getProperty("CGIBINDir1"));
            System.out.println("Port : " + properties.getProperty("port1"));
            System.out.println("Log File : " + properties.getProperty("logFileName"));
        
        }catch(Exception e){
        	System.out.println("Error: File not found");
    }
        
        
        
    
        
        if (args.length > 0) {
            rootDir = args[0];
        }
        
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                // Stick with the default value.
            }
        }
        
        try {
            WebServer server = new WebServer(rootDir, port);
            server.activate();
        }
        catch (WebServerException e) {
            System.out.println(e.toString());
 
           
        }
        
        
    }

}