package com.rickandmortyapi.service.Impl;

import com.rickandmortyapi.entity.CharacterEntity;
import com.rickandmortyapi.exception.ExistingCharacterException;
import com.rickandmortyapi.feign.RickAndMortyClient;
import com.rickandmortyapi.model.consumer.rest.CharacterMapRsDto;
import com.rickandmortyapi.model.consumer.rest.CharacterRqDto;
import com.rickandmortyapi.model.consumer.rest.CharacterRsDto;
import com.rickandmortyapi.model.consumer.rest.MessageRsDto;
import com.rickandmortyapi.model.consumer.rest.ResultRsDto;
import com.rickandmortyapi.repository.CharacterRepository;
import com.rickandmortyapi.service.IServiceCharacter;
import com.rickandmortyapi.utils.mapper.CharacterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.rickandmortyapi.utils.constant.MessageConstant.CHARACTER_ALREADY_EXISTS_DB_MESSAGE;
import static com.rickandmortyapi.utils.constant.MessageConstant.CHARACTER_ALREADY_EXISTS_MESSAGE;
import static com.rickandmortyapi.utils.constant.MessageConstant.NULL_PARAMETER_MESSAGE;
import static com.rickandmortyapi.utils.constant.MessageConstant.SUCCESSFUL_REGISTRATION_MESSAGE;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements IServiceCharacter {

    private final RickAndMortyClient client;

    private final CharacterRepository characterRepository;

    private final CharacterMapper characterMapper;

    /**
     * Get all characters from Rick & Morty external API
     * and maps them to CharacterMapRsDto objects.
     * @return list of mapped characters.
     */
    @Override
    public List<CharacterMapRsDto> getAllCharacters(){
        CharacterRsDto response = client.getCharacters();
        return response.getResults()
                .stream()
                .map(result -> characterMapper.mapTOCharacter(result))
                .collect(Collectors.toList());

    }

    /**
     * Register a new character, verifying that it does not previously exist.
     * Validate in the API and database before registering.
     * @param characterRqDto character data to register
     * @return Registration success or error message.
     * @throws ExistingCharacterException if it already exists.
     */
    @Override
    public MessageRsDto createCharacter(CharacterRqDto characterRqDto){
        try{
            if (Objects.isNull(characterRqDto)){
                throw new NullPointerException(NULL_PARAMETER_MESSAGE);
            }
            validateCharacter(characterRqDto);

            CharacterEntity character = characterMapper.mapToCharacterEntity(characterRqDto);
            characterRepository.save(character);

            return MessageRsDto.builder()
                    .message(SUCCESSFUL_REGISTRATION_MESSAGE)
                    .build();

        }catch (ExistingCharacterException e){
            return MessageRsDto.builder()
                    .message(e.getMessage())
                    .build();
        }
    }

    /**
     * Validates that the character to be registered does not previously exist
     * in the external API or database.
     * @throws ExistingCharacterException if the character already exists
     * @author Bairon Suarez
     */
    private void validateCharacter(CharacterRqDto characterRqDto) {
        CharacterRsDto characterRs = client.getCharacters();

        for (ResultRsDto resultRsDto : characterRs.getResults()){

            if (characterRqDto.getName().equals(resultRsDto.getName())){
                throw new ExistingCharacterException(CHARACTER_ALREADY_EXISTS_MESSAGE);
            }
        }
        if(characterRepository.existsByName(characterRqDto.getName())) {
            throw new ExistingCharacterException(CHARACTER_ALREADY_EXISTS_DB_MESSAGE);
        }

    }


}
