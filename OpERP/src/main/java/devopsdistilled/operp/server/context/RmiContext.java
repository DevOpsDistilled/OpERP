package devopsdistilled.operp.server.context;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import devopsdistilled.operp.server.service.ItemService;

@Configuration
public class RmiContext {
    /*
     * @Bean
     * public ItemService itemService() {
     * return new ItemServiceImpl();
     * }
     */
    @Inject
    private ItemService itemService;

    @Bean
    public RmiServiceExporter rmiServiceExporter() {
	RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
	rmiServiceExporter.setServiceName("ItemService");
	rmiServiceExporter.setServiceInterface(ItemService.class);
	rmiServiceExporter.setService(itemService);
	rmiServiceExporter.setRegistryPort(1099); // default
	return rmiServiceExporter;
    }
}
