package ma.nemo.assignment.mapper;


import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.Supply;
import ma.nemo.assignment.dto.SupplyDto;

public class SupplyMapper {
    private static Supply supply;

    public static Supply fromDTO(SupplyDto supplyDto, ProductModel productModdel) {
        supply = new Supply();
        supply.setQuantity(supplyDto.getQuantity());
        supply.setProductModel(productModdel);
        return supply;
    }
}
