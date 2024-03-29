package com.example.hellospring.cor;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TechnicalFieldsResponse {
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Asia/Tashkent")
    public Date createdAt;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Asia/Tashkent")
    public Date updatedAt;
    public UserMin createdBy;
    public UserMin updatedBy;
    public Status status;
}
