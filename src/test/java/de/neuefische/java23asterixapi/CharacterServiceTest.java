package de.neuefische.java23asterixapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class CharacterServiceTest {
    CharacterRepo characterRepo = mock(CharacterRepo.class);
    CharacterService characterService = new CharacterService(characterRepo);
    @Test
    void testGetAllCharacters_whenCalled_thenReturnsAllCharacters(){
        //GIVEN
        List<Character> characters = List.of(new Character("123", "Hans", 23, "Metzger"));
        when(characterRepo.findAll()).thenReturn(characters);
        //WHEN

        List<Character> actual = characterService.getAllCharacters();
        //THEN

        List<Character> expected = List.of(new Character("123", "Hans", 23, "Metzger"));

        verify(characterRepo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void testGetCharacterById_whenCalledWithId123_thenReturnPersonHans () {
        //GIVEN
        when(characterRepo.findById("123")).thenReturn(Optional.of(new Character("123", "Hans", 23, "Metzger")));
        //WHEN
        Character actual = characterService.getCharacterById("123");
        //THEN
        Character expected = new Character("123", "Hans", 23, "Metzger");
        verify(characterRepo).findById("123");
        assertEquals(expected, actual);

    }


}