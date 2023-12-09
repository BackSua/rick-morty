package com.rickandmortyapi.controller;

import com.rickandmortyapi.model.consumer.rest.CharacterMapRsDto;
import com.rickandmortyapi.model.consumer.rest.CharacterRqDto;
import com.rickandmortyapi.model.consumer.rest.MessageRsDto;
import com.rickandmortyapi.service.IServiceCharacter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rickandmortyapi.utils.constant.URLConstant.CHARACTER;
import static com.rickandmortyapi.utils.constant.URLConstant.CREATE_CHARACTER_ENDPOINT;
import static com.rickandmortyapi.utils.constant.URLConstant.GET_ALL_CHARACTER_ENDPOINT;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = CHARACTER)
@Api(description = "Character queries", tags = "Character Api")
public class CharacterController {

    private final IServiceCharacter serviceCharacter;

    @ApiOperation(value = "Get all Characters")
    @ApiResponse(code = 200, message = "Found the Characters")
    @GetMapping(value = GET_ALL_CHARACTER_ENDPOINT)
    public List<CharacterMapRsDto> getAllCharacter(){
        return serviceCharacter.getAllCharacters();
    }

    @ApiOperation(value = "Create a new Character")
    @ApiResponse(code = 201, message = "Character Created")
    @PostMapping(value = CREATE_CHARACTER_ENDPOINT)
    public MessageRsDto createCharacter(@RequestBody CharacterRqDto characterRqDto){
        return serviceCharacter.createCharacter(characterRqDto);
    }
}
