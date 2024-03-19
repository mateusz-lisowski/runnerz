package com.github.mateuszlisowski.springtutorialrunnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {

    private final List<Run> inMemRuns = new ArrayList<>();

    public List<Run> getAllRuns() {
        return inMemRuns;
    }

    public Optional<Run> getRunByID(Integer id) {
        return inMemRuns.stream()
                .filter(run -> Objects.equals(run.id(), id))
                .findFirst();
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
