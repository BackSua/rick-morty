package com.rickandmortyapi.controller;

import com.rickandmortyapi.model.consumer.rest.CharacterMapRsDto;
import com.rickandmortyapi.service.IServiceCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rickandmortyapi.utils.constant.URLConstant.GET_ALL_CHARACTER_ENDPOINT;

@RestController
@RequiredArgsConstructor
public class CharacterController {

    private final IServiceCharacter serviceCharacter;

    @GetMapping(value = GET_ALL_CHARACTER_ENDPOINT)
    public List<CharacterMapRsDto> getAllCharacter() throws Exception{
        return serviceCharacter.getAllCharacters();
    }
}
