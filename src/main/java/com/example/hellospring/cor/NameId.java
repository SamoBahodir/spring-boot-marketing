package com.example.hellospring.cor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NameId {
    private Long id;
    private Name name;
}
