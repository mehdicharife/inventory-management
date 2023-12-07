package ma.nemo.assignment.repository;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.domain.ProductModel;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByExpirationDateBefore(Date date);

    @Query("SELECT p FROM Product p WHERE p.productModel.productCode = :#{#productCode}")
    List<Product> findAllByProductCode(@Param("productCode") String productCode);
    
    @Query("SELECT SUM(quantity) FROM Product p WHERE p.productModel.id = :#{#productModel.id}")
    long sumQuantityByProductModel(@Param("productModel") ProductModel productModel);

    @Query("SELECT SUM(quantity) FROM Product p WHERE p.productModel.productCode = :#{#productCode}")
    long sumQuantityByProductCode(@Param("productCode") String productCode);

    List<Product> findAllByOrderByExpirationDateAsc();
}