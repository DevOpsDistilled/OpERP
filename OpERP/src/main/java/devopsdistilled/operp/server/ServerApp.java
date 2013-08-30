package devopsdistilled.operp.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.context.AppContext;

public class ServerApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppContext.class);

		Properties hibernateProperties = new Properties();
		URL hibernatePropertiesFileUrl = ServerApp.class.getClassLoader()
				.getResource("server/hibernate.properties");
		File hibernatePropertiesFile = new File(
				hibernatePropertiesFileUrl.getFile());
		try {
			InputStream in = new FileInputStream(hibernatePropertiesFile);
			hibernateProperties.load(in);
			String hbm2dllKey = "hibernate.hbm2ddl.auto";
			String hbm2ddlValue = hibernateProperties.getProperty(hbm2dllKey);

			if (hbm2ddlValue.equalsIgnoreCase("create"))
				hibernateProperties.setProperty(hbm2dllKey, "update");

			in.close();
			OutputStream out = new FileOutputStream(hibernatePropertiesFile);
			hibernateProperties.store(out, null);

		} catch (IOException e) {
			System.err.println("hibernate.properties file not found!");
			e.printStackTrace();
		}

		System.out.println(context);
	}
}
