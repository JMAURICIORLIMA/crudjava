package com.senai.crudjava.controller;

import com.senai.crudjava.domain.Manufacturer;
import com.senai.crudjava.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturer() {
        return ResponseEntity.ok().body(manufacturerService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> addManufacturer(@RequestBody Manufacturer manufacturer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(manufacturerService.save(manufacturer));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getManufacturer(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(manufacturerService.getManufacturerById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteManufacturer(@PathVariable(value = "id") Long id) {
        manufacturerService.deleteManufacturerById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Manufacturer successfully deleted from database");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateManufacturer(@PathVariable(value = "id") Long id, @RequestBody Manufacturer manufacturer) {
        Optional<Manufacturer> dataManufacturer = manufacturerService.getManufacturerById(id);
        Manufacturer changeManufacturer = dataManufacturer.get();
        changeManufacturer.setBrand(manufacturer.getBrand());
        changeManufacturer.setModel(manufacturer.getModel());
        changeManufacturer.setYear(manufacturer.getYear());

        return ResponseEntity.status(HttpStatus.OK).body(manufacturerService.save(changeManufacturer));
    }


}
