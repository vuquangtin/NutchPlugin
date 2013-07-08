package org.apache.nutch.indexer.ontoindexer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	public static final String urlDBServerIp;
	public static final String urlDBServerPort;
	public static final String urlDBName;
	public static final String urlDBUser;
	public static final String urlDBPassword;
	
	static{
		Properties p = new Properties();
		InputStream in = null;
		String path = System.getenv("ONTO_CONFIG") + "/ontostar.properties";
		try {
			in = new FileInputStream(path);
			p.load(in);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("Could not find or open " +path);
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not read " + path);
		}
		
		urlDBName = p.getProperty("url_database_name").trim();
		urlDBUser = p.getProperty("url_databse_user").trim();
		urlDBPassword = p.getProperty("url_database_password").trim();
		urlDBServerIp = p.getProperty("url_databse_server_ip").trim();
		urlDBServerPort = p.getProperty("url_databse_server_port").trim();
		
		try {
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
