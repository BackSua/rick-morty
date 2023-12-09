package com.rickandmortyapi.model.consumer.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterRqDto {

    @JsonProperty(value = "imagen")
    private String imagen;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "gender")
    private String gender;
    @JsonProperty(value = "status")
    private String status;

}
