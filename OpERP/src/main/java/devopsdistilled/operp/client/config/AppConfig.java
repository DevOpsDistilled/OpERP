package devopsdistilled.operp.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RmiConfig.class)
public class AppConfig {

}
