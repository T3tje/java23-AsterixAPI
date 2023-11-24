package de.neuefische.java23asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepo repo;

    public List<Character> getAllCharacters() {
        return repo.findAll();
    }


    public void savePerson(NewCharacterDTO character) {
        Character newCharacter = new Character(UUID.randomUUID().toString(), character.name(), character.age(), character.role());

        repo.save(newCharacter);
    }

    public Character getCharacterById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    /*

    public Person findByName(String name){
        return repo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }
    */

}
