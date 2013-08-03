package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.models.CreateCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateProductPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditProductPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListProductPaneModel;
import devopsdistilled.operp.client.items.panes.models.impl.CreateCategoryPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.CreateItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.CreateProductPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.EditCategoryPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.EditItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.EditProductPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.ListCategoryPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.ListItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.ListProductPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public CreateItemPaneModel createItemPaneModel() {
		return new CreateItemPaneModelImpl();
	}

	@Bean
	public ListItemPaneModel listItemPaneModel() {
		return new ListItemPaneModelImpl();
	}

	@Bean
	public EditItemPaneModel editItemPaneModel() {
		return new EditItemPaneModelImpl();
	}

	@Bean
	public CreateCategoryPaneModel createCategoryPaneModel() {
		return new CreateCategoryPaneModelImpl();
	}

	@Bean
	public EditCategoryPaneModel editCategoryPaneModel() {
		return new EditCategoryPaneModelImpl();
	}

	@Bean
	public ListCategoryPaneModel listCategoryPaneModel() {
		return new ListCategoryPaneModelImpl();
	}

	@Bean
	public CreateProductPaneModel createProductPaneModel() {
		return new CreateProductPaneModelImpl();
	}

	@Bean
	public ListProductPaneModel listProductPaneModel() {
		return new ListProductPaneModelImpl();
	}

	@Bean
	public EditProductPaneModel editProductPaneModel() {
		return new EditProductPaneModelImpl();
	}
}
