package com.ptvprueba.ptvtelecom.common.entities;

import jakarta.persistence.*;
import lombok.*;


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
    private String id;
    private String dni;
    private String nombre;
    private String email;
    private String firma;
}
