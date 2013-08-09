package devopsdistilled.operp.client.context.items;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({  LocalContext.class })
public class ItemContext {

}
