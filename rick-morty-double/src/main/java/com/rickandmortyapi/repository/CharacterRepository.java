package com.rickandmortyapi.repository;

import com.rickandmortyapi.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity,Long> {

    @Query(value = "" +
            "SELECT CASE WHEN EXISTS " +
            "(SELECT 1 FROM character ca WHERE ca.character_name = :name) " +
            "THEN true ELSE false END",
             nativeQuery = true)
    Boolean existsByName(String name);
}
