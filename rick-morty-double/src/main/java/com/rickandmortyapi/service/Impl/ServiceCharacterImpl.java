package com.rickandmortyapi.service.Impl;

import com.rickandmortyapi.feign.RickAndMortyClient;
import com.rickandmortyapi.model.consumer.rest.CharacterMapRsDto;
import com.rickandmortyapi.model.consumer.rest.CharacterRsDto;
import com.rickandmortyapi.model.consumer.rest.ResultRsDto;
import com.rickandmortyapi.service.IServiceCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceCharacterImpl implements IServiceCharacter {

    private final RickAndMortyClient client;

    @Override
    public List<CharacterMapRsDto> getAllCharacters() throws Exception {
        CharacterRsDto response = client.getCharacters();
        return response.getResults()
                .stream()
                .map(this::mapTOCharacter)
                .collect(Collectors.toList());

    }

    private CharacterMapRsDto mapTOCharacter(ResultRsDto resultRsDto){
        CharacterMapRsDto characterMapRsDto = CharacterMapRsDto.builder()
                .name(resultRsDto.getName())
                .status(resultRsDto.getStatus())
                .gender(resultRsDto.getGender())
                .imagen(resultRsDto.getImage())
                .build();
        return characterMapRsDto;
    }
}
