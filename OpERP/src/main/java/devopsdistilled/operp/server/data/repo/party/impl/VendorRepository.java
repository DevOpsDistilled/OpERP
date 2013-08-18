package devopsdistilled.operp.server.data.repo.party.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.party.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
