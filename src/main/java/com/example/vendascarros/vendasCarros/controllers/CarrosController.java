package com.example.vendascarros.vendasCarros.controllers;

import com.example.vendascarros.vendasCarros.domain.carros.Carros;
import com.example.vendascarros.vendasCarros.domain.carros.CarrosRepository;
import com.example.vendascarros.vendasCarros.domain.carros.RequestCarros;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    @Autowired
    private CarrosRepository repository;

    @GetMapping
    public ResponseEntity getAllCarros(){
        var allCarros = repository.findAll();
        return ResponseEntity.ok(allCarros);
    }

    @PostMapping
    public ResponseEntity registerCarros(@RequestBody @Valid RequestCarros data){
        Carros newCarro = new Carros(data);
        repository.save(newCarro);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCarros(@RequestBody @Valid RequestCarros data){
        Optional<Carros> optionalCarro = repository.findById(data.id());
        if (optionalCarro.isPresent()){
            Carros carros = optionalCarro.get();
            carros.setModelo_carro(data.modelo_carro());
            carros.setPreco_carro(data.preco_carro());
            return ResponseEntity.ok(carros);
        }else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarros(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
