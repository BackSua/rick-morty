package com.rickandmortyapi.service;

import com.rickandmortyapi.model.consumer.rest.CharacterMapRsDto;
import com.rickandmortyapi.model.consumer.rest.CharacterRqDto;
import com.rickandmortyapi.model.consumer.rest.MessageRsDto;


import java.util.List;

public interface IServiceCharacter {

    List<CharacterMapRsDto> getAllCharacters();

    MessageRsDto createCharacter(CharacterRqDto characterRqDto);

}
