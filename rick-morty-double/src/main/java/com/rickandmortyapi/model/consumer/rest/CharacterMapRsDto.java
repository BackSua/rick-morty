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
public class CharacterMapRsDto {
    private String imagen;
    private String name;
    private String gender;
    private String status;
}
