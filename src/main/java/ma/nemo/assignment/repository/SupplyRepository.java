package ma.nemo.assignment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nemo.assignment.domain.Supply;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long>{
    
}
