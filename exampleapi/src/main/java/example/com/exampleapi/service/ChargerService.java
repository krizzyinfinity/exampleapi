package example.com.exampleapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.com.exampleapi.domain.AddressInfo;
import example.com.exampleapi.domain.Charger;
import example.com.exampleapi.repository.ChargerRepository;

@Service
public class ChargerService {
    @Autowired
    private ChargerRepository chargerRepository;

    public ChargerService(ChargerRepository chargerRepository) {
        this.chargerRepository = chargerRepository;
    }

    public Iterable<Charger> getProducts() {
        return chargerRepository.findAll();
    }

    public Charger getProductById(int id) {
        return chargerRepository.findById(id).orElse(null);
    }

    public void save(List<Charger> charger) {
        chargerRepository.saveAll(charger);
    }

    public Charger saveProduct(Charger charger) {
        return chargerRepository.save(charger);
    }

    public Iterable<Charger> saveProducts(List<Charger> chargers) {
        return chargerRepository.saveAll(chargers);
    }

    public AddressInfo save(AddressInfo address) {
        return ChargerRepository.save(address);
    }

    public String deleteProduct(int id) {
        chargerRepository.deleteById(id);
        return "deleted " + id;
    }

    // public Charger getProductByTown(String Town) {
    // return chargerRepository.findByTown(Town);
    // }

}
