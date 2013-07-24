package devopsdistilled.operp.server.data.repo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.data.entity.stock.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
