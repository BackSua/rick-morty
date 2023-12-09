package com.rickandmortyapi.model.consumer.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultRsDto {
    private Integer id;
    private String name;
    private String status;
    private String gender;
    private String image;
}
