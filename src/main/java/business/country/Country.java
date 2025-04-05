package business.country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
@NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name AND c.active = true")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "name", nullable = false, unique = true)
    @JoinColumn(unique = true)
    private String name;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "path_img")
    private String pathImg;
    @Version
    @Column(name = "version")
    private int version;
}
