package ma.nemo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nemo.assignment.domain.ProductReturn;


@Repository
public interface ProductReturnRepository extends JpaRepository<ProductReturn, Long> {
    
}
