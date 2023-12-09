package com.rickandmortyapi.feign;

import com.rickandmortyapi.model.consumer.rest.CharacterRsDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import static com.rickandmortyapi.utils.constant.URLConstant.CHARACTER;
import static com.rickandmortyapi.utils.constant.URLConstant.RICK_AND_MORTY_ENDPOINT;

@FeignClient(url = RICK_AND_MORTY_ENDPOINT, name = "rickAndMortyClient")
public interface RickAndMortyClient {

    @GetMapping(CHARACTER)
    CharacterRsDto getCharacters();
}
