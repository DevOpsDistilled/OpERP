package devopsdistilled.operp.server.data.service.items.impl;

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

}
