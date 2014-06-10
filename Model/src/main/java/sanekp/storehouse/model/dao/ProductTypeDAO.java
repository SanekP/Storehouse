package sanekp.storehouse.model.dao;

import sanekp.storehouse.model.entity.ProductTypeEntity;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by sanek_000 on 6/10/2014.
 */
@Stateless
public class ProductTypeDAO extends DAO<ProductTypeEntity, Long> {
    public ProductTypeDAO() {
        super(ProductTypeEntity.class);
    }

    public List<ProductTypeEntity> listAll() {
        return list("ProductType.findAll");
    }
}
