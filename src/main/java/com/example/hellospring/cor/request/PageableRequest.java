package com.example.hellospring.cor.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageableRequest {
    @Schema(name = "per_page",
            description = "На страницу",
            example = "10")
    private int perPage = 10;

    @Schema(description = "Страница", example = "1")
    private int page = 0;

    @Schema(description = "Сортировать данные")
    private Sort sort = new Sort();


    private List<SearchCriteria> search;
}
