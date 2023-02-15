package com.example.hellospring.cor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class GenericDto {
    @JsonIgnore
    private final Map<String, Object> properties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return this.properties;
    }

    @JsonAnySetter
    public void addProperty(String name, Object value) {
        this.properties.put(name, value);
    }
}
