package devopsdistilled.operp.server.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ JpaContext.class })
public class AppContext {

	/*@Bean
	public ServerApp serverApp() {
		return new ServerApp();
	}*/
}
