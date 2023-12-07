package ma.nemo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nemo.assignment.domain.Sale;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
