package de.neuefische.java23asterixapi;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document("character")
public record Character(String id, String name, int age, String role) {
}
