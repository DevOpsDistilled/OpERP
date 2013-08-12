package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;

@Configuration
@Import({ MvcModelContext.class, MvcViewContext.class,
		MvcControllerContext.class })
public class MvcContext {

}
