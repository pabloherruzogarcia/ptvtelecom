package com.ptvprueba.ptvtelecom.common.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNullApi;

import java.awt.*;


@Entity
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dni;
    private String nombre;
    private String email;
    private Canvas firma;
}
