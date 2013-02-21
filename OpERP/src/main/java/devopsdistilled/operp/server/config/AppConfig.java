package devopsdistilled.operp.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ JpaConfig.class, RmiConfig.class })
public class AppConfig {

}
