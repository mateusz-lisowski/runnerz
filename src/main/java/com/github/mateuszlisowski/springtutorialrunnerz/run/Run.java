package com.github.mateuszlisowski.springtutorialrunnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime finishedOn,
        @Positive
        Integer kilometers,
        Location location
) {
    public Run {
        if(!finishedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Finished time must be after started time");
        }
    }
}
