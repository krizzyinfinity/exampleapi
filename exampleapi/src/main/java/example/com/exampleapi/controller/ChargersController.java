package example.com.exampleapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import example.com.exampleapi.domain.Charger;

import example.com.exampleapi.service.ChargerService;

@RestController

public class ChargersController {
    @Autowired
    private ChargerService chargerService;

    public ChargersController(ChargerService chargerService) {
        this.chargerService = chargerService;
    }

    @GetMapping("/products")
    public Iterable<Charger> findAllProducts() {
        return chargerService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Charger findProductById(@PathVariable int id) {
        return chargerService.getProductById(id);
    }

    @PostMapping("/addProduct")
    public Charger addProduct(@RequestBody Charger charger) {
        return chargerService.saveProduct(charger);
    }

    @PostMapping("/addProducts")
    public Iterable<Charger> addProducts(@RequestBody List<Charger> chargers) {
        return chargerService.saveProducts(chargers);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@RequestBody int id) {
        return chargerService.deleteProduct(id);
    }

    // @GetMapping("/product/{Town}")
    // public Charger findProductByTown(@PathVariable String Town) {
    // return chargerService.getProductByTown(Town);
    // }

}