package devopsdistilled.operp.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerApp {
    public static void main(String[] args) {

	ApplicationContext ctx = new AnnotationConfigApplicationContext(
		"devopsdistilled.operp.server");

	System.out.println(ctx.toString());
    }
}
