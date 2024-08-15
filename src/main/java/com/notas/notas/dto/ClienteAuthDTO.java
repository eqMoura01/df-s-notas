package com.notas.notas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteAuthDTO {
    
    private Long id;
    private String username;
    private String password;

}
 