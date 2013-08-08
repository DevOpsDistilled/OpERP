package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.context.items.ItemContext;

@Configuration
@Import({ ItemContext.class })
public class AppContext {

}
