package com.senai.crudjava.service;

import com.senai.crudjava.domain.Manufacturer;
import com.senai.crudjava.domain.Vehicle;
import com.senai.crudjava.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll(){
        List<Manufacturer> allManufacrer = manufacturerRepository.findAll();
        return allManufacrer;
    }


    @Transactional
    public Manufacturer save(Manufacturer manufacturer){
        Vehicle hatch = new Vehicle(1L);
        Vehicle sedan = new Vehicle(2L);
        Vehicle suv = new Vehicle(3L);
        Vehicle outros = new Vehicle(4L);
        
        return manufacturerRepository.save(manufacturer);
    }

    public Optional<Manufacturer> getManufacturerById(Long id){
        return manufacturerRepository.findById(id);
    }

    @Transactional
    public void deleteManufacturerById(Long id){
        manufacturerRepository.deleteById(id);
    }


}
