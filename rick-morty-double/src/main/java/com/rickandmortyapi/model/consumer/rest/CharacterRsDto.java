package com.rickandmortyapi.model.consumer.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterRsDto {
    private InfoRsDto info;
    private List<ResultRsDto> results;
}
