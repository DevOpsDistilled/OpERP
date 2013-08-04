package devopsdistilled.operp.server.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.server.context.items.ItemContext;

@Configuration
@Import({ JpaContext.class, ItemContext.class })
public class AppContext {

}
