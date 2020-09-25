
package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


/**
 *
 * @author Bruno Tarditi
 */

@MappedSuperclass// clase padre de las entidades
@Inheritance(strategy = InheritanceType.JOINED)
public class EntityApp {

    private long id;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
