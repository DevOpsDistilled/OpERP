package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RmiContext.class)
@ComponentScan("devopsdistilled.operp.server")
public class AppContext {

}
