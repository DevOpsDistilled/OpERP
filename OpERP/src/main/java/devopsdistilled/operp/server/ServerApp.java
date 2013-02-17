package devopsdistilled.operp.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.config.AppConfig;

public class ServerApp {
    public static void main(String[] args) {

	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

	System.out.println(ctx.toString());
    }
}
