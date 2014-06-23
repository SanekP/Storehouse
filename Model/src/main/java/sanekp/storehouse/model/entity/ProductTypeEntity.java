package sanekp.storehouse.model.entity;

import javax.persistence.*;

/**
 * Created by sanek_000 on 6/10/2014.
 */
@Entity
@Table(name = "t_product_type", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@NamedQueries({@NamedQuery(name = "ProductType.findAll", query = "SELECT o FROM ProductTypeEntity o ORDER BY o.name")})
public class ProductTypeEntity extends AbstractEntity {
    private String name;

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
