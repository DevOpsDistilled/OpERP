package devopsdistilled.operp.server.context.items;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ RmiContext.class })
public class ItemContext {

}
