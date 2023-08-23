package com.example.vendascarros.vendasCarros.domain.carros;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Classe para criar um DTO de forma rapida
public record RequestCarros(String id, @NotBlank String modelo_carro, @NotNull Float preco_carro) {

}
