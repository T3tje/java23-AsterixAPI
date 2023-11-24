package de.neuefische.java23asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
@RequiredArgsConstructor
public class AsterixController {

    //private final CharacterService service;
    private final CharacterService service;

    @GetMapping
    public List<Character> getAllCharacters (){
        return service.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById (@PathVariable String id) {
        return service.getCharacterById(id);
    }

    @PostMapping
    public void savePerson(@RequestBody NewCharacterDTO character){
        service.savePerson(character);
    }

}
