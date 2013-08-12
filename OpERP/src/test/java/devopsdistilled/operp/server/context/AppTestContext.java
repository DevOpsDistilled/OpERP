package devopsdistilled.operp.server.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ JpaTestContext.class })
public class AppTestContext {

	/*
	 * @Bean public ServerApp serverApp() { return new ServerApp(); }
	 */
}
