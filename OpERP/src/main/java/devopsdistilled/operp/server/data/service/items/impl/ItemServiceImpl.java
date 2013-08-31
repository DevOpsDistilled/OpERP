package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Service;

import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.repo.items.ItemRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.items.ItemService;

@Service
public class ItemServiceImpl extends
		AbstractEntityService<Item, Long, ItemRepository> implements
		ItemService {

	private static final long serialVersionUID = 7578267584162733059L;

	@Inject
	private ItemRepository itemRepository;

	@Inject
	private ApplicationContext context;

	@Override
	protected ItemRepository getRepo() {
		return itemRepository;
	}

	@Override
	public boolean isProductBrandPairExists(Product product, Brand brand) {
		Item item = itemRepository.findByProductAndBrand(product, brand);
		if (item != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean isItemNameExists(String itemName) {
		Item item = itemRepository.findByItemName(itemName);

		if (item != null)
			return true;
		else
			return false;
	}

	/**
	 * Returns false if Product and Brand Pair exists and the pair doesn't
	 * belong to given itemId. Else returns true
	 */
	@Override
	public boolean isProductBrandPairValidForItem(Long itemId, Product product,
			Brand brand) {

		Item item = itemRepository.findByProductAndBrand(product, brand);

		if (item == null)
			return true;

		if (item.getItemId().equals(itemId))
			return true;

		return false;
	}

	/**
	 * Returns false if ItemName exists for Item other than Item with given
	 * itemId. Else return true
	 */
	@Override
	public boolean isItemNameValidForItem(Long itemId, String itemName) {

		Item item = itemRepository.findByItemName(itemName);

		if (item == null)
			return true;

		if (item.getItemId().equals(itemId))
			return true;

		return false;
	}

	@Override
	protected Item findByEntityName(String entityName) {
		return itemRepository.findByItemName(entityName);
	}

	@Override
	public void registerClient(String clientAddress) {
		System.out.println("Client from " + clientAddress);
		//
		// RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		// rmiProxy.setServiceInterface(ItemModel.class);
		// String serviceName =
		// rmiProxy.getServiceInterface().getCanonicalName();
		// rmiProxy.setServiceUrl("rmi://" + clientAddress + ":1099/"
		// + serviceName);

		// TestClass testing = new TestClass();

		AutowireCapableBeanFactory factory = context
				.getAutowireCapableBeanFactory();
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(RmiProxyFactoryBean.class);
		beanDefinition.setAutowireCandidate(true);

		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("serviceInterface", ItemModel.class);
		propertyValues.addPropertyValue("serviceUrl", "rmi://" + clientAddress
				+ ":1099/" + ItemModel.class.getCanonicalName());
		beanDefinition.setPropertyValues(propertyValues);

		registry.registerBeanDefinition("itemModelRmiProxyFactoryBean",
				beanDefinition);
		System.out.println(context.getBean("itemModelRmiProxyFactoryBean"));
	}
}
