package dk.highschool.values;

import java.time.Instant;

public record StudentDto(String name, Instant dateOfBirth, String email) {
    // Default is OK.
}
