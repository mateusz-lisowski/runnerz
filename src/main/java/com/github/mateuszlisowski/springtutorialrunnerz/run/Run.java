package com.github.mateuszlisowski.springtutorialrunnerz.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime finishedOn,
        Integer kilometers,
        Location location
) {}
