package devopsdistilled.operp.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.context.AppContext;

public class ServerApp {

	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public static void main(String[] args) {

		if (args.length > 0 && args[0].equalsIgnoreCase("init"))
			System.setProperty("hibernate.hbm2ddl.auto", "create");
		else
			System.setProperty("hibernate.hbm2ddl.auto", "update");

		context = new AnnotationConfigApplicationContext(AppContext.class);

		System.out.println(context);
	}

}
