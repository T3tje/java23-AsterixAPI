package de.neuefische.java23asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Character updateCharacterById(String id, Character updatedCharacter) {
        return repo.findById(id)
                .map(existingCharacter -> {
                    // Aktualisiere die Eigenschaften des bestehenden Charakters
                    Character updated = existingCharacter
                            .withName(updatedCharacter.name())
                            .withAge(updatedCharacter.age())
                            .withRole(updatedCharacter.role());

                    // Speichere den aktualisierten Charakter zurück in der Datenbank
                    return repo.save(updated);
                })
                .orElseThrow(() -> new RuntimeException("Character not found with id: " + id));
    }

    public void deleteCharacterById(String id) {
        Optional<Character> characterOptional = repo.findById(id);

        if (characterOptional.isPresent()) {
            Character characterToDelete = characterOptional.get();
            repo.delete(characterToDelete);
        } else {
            System.out.println("Character with ID " + id + " not found.");
        }
    }

}
