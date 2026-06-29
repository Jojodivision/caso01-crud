package com.caso1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "bike")
public class Bike implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bike")
    private Long idBike; // camelCase aplicado aquí

    private String marca;

    private Double velocidades;

    @Column(name = "cilindrada_bike")
    private Integer cilindradaBike; // camelCase aplicado aquí

    @Column(name = "imagen_bike")
    private String imagenBike; // camelCase aplicado aquí
}
