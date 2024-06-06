package com.ptvprueba.ptvtelecom.common.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotNull
    private String id;
    @NotNull
    private String dni;
}
