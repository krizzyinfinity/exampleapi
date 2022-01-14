package example.com.exampleapi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
// @Table(name = "charger")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Charger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "dataID")
    private Integer ID;
    @Column(name = "UUID")
    private String UUID;

    public Charger(Integer id, Integer iD2, String uUID, List<AddressInfo> address) {
        this.id = id;
        ID = iD2;
        UUID = uUID;
        this.address = address;
    }

    // @Embedded
    @OneToMany(mappedBy = "charger")
    private List<AddressInfo> address;

    public Charger() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    // public Integer getID() {
    // return ID;
    // }

    // public void setID(Integer ID) {
    // this.ID = ID;
    // }

    @Override
    public String toString() {
        return "Charger{" +
                "UUID='" + UUID + '\'' +
                ", AddressInfo=" + address +
                '}';
    }

}
