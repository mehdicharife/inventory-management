package ma.nemo.assignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.ProductModelThreshold;

@Repository
public interface ProductModelThresholdRepository extends JpaRepository<ProductModelThreshold, Long> {
    Optional<ProductModelThreshold> findByProductModel(ProductModel productModel);

    @Query("SELECT pm FROM ProductModel pm WHERE pm.id IN (SELECT pmt.productModel.id FROM ProductModelThreshold pmt)")
    List<ProductModel> findAllProductModels();
}
