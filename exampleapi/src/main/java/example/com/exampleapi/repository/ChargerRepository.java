package example.com.exampleapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import example.com.exampleapi.domain.AddressInfo;
import example.com.exampleapi.domain.Charger;

public interface ChargerRepository extends JpaRepository<Charger, Integer> {

    public default void saveAll(List<AddressInfo> address) {
        saveAll(address);
    }

    public static AddressInfo save(AddressInfo address) {

        return save(address);
    }

    // Charger findByTown(String town);

}
