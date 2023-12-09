package com.rickandmortyapi.service;

import com.rickandmortyapi.model.consumer.rest.CharacterMapRsDto;
import com.rickandmortyapi.model.consumer.rest.CharacterRsDto;

import java.util.List;

public interface IServiceCharacter {

    List<CharacterMapRsDto> getAllCharacters() throws Exception;

}
