package com.example.hellospring.cor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserMin {
    private Integer id;
    private String first_name;
    private String last_name;
}
