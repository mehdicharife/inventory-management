package ma.nemo.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.ProductModelThreshold;

@Repository
public interface ProductModelThresholdRepository extends JpaRepository<ProductModelThreshold, Long> {
    Optional<ProductModelThreshold> findByProductModel(ProductModel productModel);
}
