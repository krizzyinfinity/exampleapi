package example.com.exampleapi.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Embeddable
public class AddressInfo {
    @Id
    @GeneratedValue
    private Integer id;

    private String Title;
    private String Address1;
    private String Town;
    private String Postcode;
    private Float Latitude;
    private Float Longitude;

    @ManyToOne
    @JoinColumn(name = "charger_id")
    private Charger charger;

    public AddressInfo(Integer id, String title, String address1, String town, String postcode, Float latitude,
            Float longitude, Charger charger) {
        this.id = id;
        this.Title = title;
        this.Address1 = address1;
        this.Town = town;
        this.Postcode = postcode;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.charger = charger;
    }

    public AddressInfo() {
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        this.Postcode = postcode;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        this.Town = town;
    }

    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        this.Longitude = longitude;
    }

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        this.Latitude = latitude;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        this.Address1 = address1;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +

                ", Title=" + Title +
                "Address1='" + Address1 + '\'' +
                ", Town=" + Town +
                "Postcode='" + Postcode + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +

                '}';
    }

}
