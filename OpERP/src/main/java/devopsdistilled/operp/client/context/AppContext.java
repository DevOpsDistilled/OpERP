package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RmiContext.class)
public class AppContext {

}
