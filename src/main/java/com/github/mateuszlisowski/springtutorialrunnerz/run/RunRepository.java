package com.github.mateuszlisowski.springtutorialrunnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {

    private final List<Run> inMemRuns = new ArrayList<>();

    public List<Run> getAllRuns() {
        return inMemRuns;
    }

    @PostConstruct
    private void createMockRuns() {
        inMemRuns.add(
                new Run(
                        1,
                        "Morning swamp jogging",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusHours(1),
                        5,
                        Location.OUTDOOR
                )
        );
        inMemRuns.add(
                new Run(
                        2,
                        "Afternoon home jogging",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusHours(1),
                        10,
                        Location.INDOOR
                )
        );
    }
}
