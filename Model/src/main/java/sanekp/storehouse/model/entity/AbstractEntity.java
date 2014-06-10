package sanekp.storehouse.model.entity;

/**
 * Created by sanek_000 on 6/10/2014.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * To create ID generator sequence "s_PRODUCT_ID":
 * CREATE SEQUENCE "s_PRODUCT_ID" INCREMENT BY 50 START WITH 50;
 */

@MappedSuperclass
@SequenceGenerator(name = "ProductEntity_Id_Seq_Gen", sequenceName = "s_PRODUCT_ID", allocationSize = 50,
        initialValue = 50)
public abstract class AbstractEntity implements Serializable {
    private Long id;
    private Timestamp modified;
    private Timestamp version;

    @PrePersist
    public void prePersist() {
        setModified(new Timestamp(System.currentTimeMillis()));
    }

    @Id
    @GeneratedValue
    //    @GeneratedValue(generator = "ProductEntity_Id_Seq_Gen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @Version
    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }
}
