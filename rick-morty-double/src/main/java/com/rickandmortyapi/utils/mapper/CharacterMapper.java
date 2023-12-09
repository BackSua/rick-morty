package com.rickandmortyapi.utils.mapper;

import com.rickandmortyapi.entity.CharacterEntity;
import com.rickandmortyapi.model.consumer.rest.CharacterMapRsDto;
import com.rickandmortyapi.model.consumer.rest.CharacterRqDto;
import com.rickandmortyapi.model.consumer.rest.ResultRsDto;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    public CharacterMapRsDto mapTOCharacter(ResultRsDto resultRsDto){
        CharacterMapRsDto characterMapRsDto = CharacterMapRsDto.builder()
                .name(resultRsDto.getName())
                .status(resultRsDto.getStatus())
                .gender(resultRsDto.getGender())
                .imagen(resultRsDto.getImage())
                .build();
        return characterMapRsDto;
    }

    public CharacterEntity mapToCharacterEntity(CharacterRqDto characterRqDto){
        CharacterEntity characterEntity = CharacterEntity.builder()
                .status(characterRqDto.getStatus())
                .name(characterRqDto.getName())
                .gender(characterRqDto.getGender())
                .imagen(characterRqDto.getImagen())
                .build();
        return characterEntity;
    }

}
