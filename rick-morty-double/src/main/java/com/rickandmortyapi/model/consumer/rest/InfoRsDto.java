package com.rickandmortyapi.model.consumer.rest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoRsDto {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
