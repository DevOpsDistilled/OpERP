package devopsdistilled.operp.server.data.service.items.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.repo.items.BrandRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractServiceImpl;
import devopsdistilled.operp.server.data.service.items.BrandService;

@Service
public class BrandServiceImpl extends AbstractServiceImpl<Brand, Long>
		implements BrandService {

	private static final long serialVersionUID = -9026551460330247355L;

	@Inject
	private BrandRepository brandRepository;

	@Override
	protected JpaRepository<Brand, Long> getRepo() {
		return brandRepository;
	}

	@Override
	public List<Brand> findAll() {
		Brand one = new Brand();
		Brand two = new Brand();
		Brand three = new Brand();
		Brand four = new Brand();
		Brand five = new Brand();
		List<Brand> brands = new ArrayList<>();
		brands.add(one);
		brands.add(two);
		brands.add(three);
		brands.add(four);
		brands.add(five);

		return brands;

	}

}
