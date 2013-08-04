package devopsdistilled.operp.server.data.repo.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.items.Manufacturer;

@Repository
public interface ManufacturerRepository extends
		JpaRepository<Manufacturer, Long> {

	public Manufacturer findByManufacturerName(String manufacturerName);
}
