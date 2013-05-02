package devopsdistilled.operp.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.context.AppContext;
import devopsdistilled.operp.server.data.entity.Product;
import devopsdistilled.operp.server.data.repo.ProductRepository;

public class ServerApp {
	/*
	 * @Inject ItemRepository itemRepository;
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppContext.class);
		ProductRepository productRepository = context
				.getBean(ProductRepository.class);
		Product product = new Product();
		product.setProductName("Product Test");
		product = productRepository.save(product);
		System.out.println(productRepository.findOne(product.getProductId()));
		System.out.println(context);
	}
}
