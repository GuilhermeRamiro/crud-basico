package com.example.vendascarros.vendasCarros.domain.carros;

import jakarta.persistence.*;
import lombok.*;

@Table(name="carros")
@Entity(name = "carros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carros {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String modelo_carro;

    private Float preco_carro;

    public Carros(RequestCarros requestCarros){
        this.modelo_carro = requestCarros.modelo_carro();
        this.preco_carro = requestCarros.preco_carro();

    }

}
