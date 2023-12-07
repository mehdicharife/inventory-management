package ma.nemo.assignment.strategy;

import java.util.List;

import ma.nemo.assignment.domain.Product;


public interface ProductSelectionStrategy {
    List<Product> selectProducts(List<Product> products, long quantity);    
}
