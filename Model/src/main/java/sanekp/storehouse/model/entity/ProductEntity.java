package sanekp.storehouse.model.entity;

import javax.persistence.*;

/**
 * Created by sanek_000 on 6/23/2014.
 */
@Entity
@Table(name = "t_product", uniqueConstraints = {@UniqueConstraint(columnNames = {"type", "name"})})
@NamedQueries({@NamedQuery(name = "Product.findAll", query = "SELECT o FROM ProductEntity o ORDER BY o.type.name, o.name")})
public class ProductEntity extends AbstractEntity {
    private ProductTypeEntity type;
    private String name;
    private String size;
    private String description;

    @JoinColumn(name = "type", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public ProductTypeEntity getType() {
        return type;
    }

    public void setType(ProductTypeEntity type) {
        this.type = type;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
