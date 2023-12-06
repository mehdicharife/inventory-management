package ma.nemo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.nemo.assignment.domain.ProductModelThreshold;

public interface ProductModelThresholdRepository extends JpaRepository<ProductModelThreshold, Long> {
    
}
