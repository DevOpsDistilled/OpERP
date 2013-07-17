package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ UIContext.class, RmiContext.class })
public class AppContext {

}
