package ma.nemo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nemo.assignment.domain.ProductModel;
import java.util.Optional;


@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Long>{
    Optional<ProductModel> findByProductCode(String productCode);
}
