package devopsdistilled.operp.server.data.service;

import javax.inject.Inject;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.context.AppTestContext;
import devopsdistilled.operp.server.data.entity.Manufacturer;
import devopsdistilled.operp.server.data.repo.ManufacturerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestContext.class)
@Transactional
public class ManufacturerServiceTest {

	@Inject
	private ManufacturerRepository repo;
	Manufacturer manufacturer;

	@Before
	public void setUp() throws Exception {
		Assert.assertNotNull("Repository shouldn't be null", repo);
		manufacturer = new Manufacturer();
		manufacturer.setManufacturerName("Manufacturer Test");
	}

	@Test
	public void testSave() {
		Manufacturer savedManufacturer = repo.save(manufacturer);

		Assert.assertThat("Saved and returned object must be same",
				manufacturer, CoreMatchers.is(savedManufacturer));
		Assert.assertThat("Found and saved must be same", manufacturer,
				CoreMatchers.is(repo.findOne(savedManufacturer
						.getManufacturerId())));
	}

}
