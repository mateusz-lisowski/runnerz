package com.github.mateuszlisowski.springtutorialrunnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository repository;

    public RunController(RunRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Run> getAllRuns() {
        return repository.getAllRuns();
    }

    @GetMapping("/{id}")
    Run getRunById(@PathVariable Integer id) {
        Optional<Run> run = repository.getRunByID(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run with id " + id + " does not exist");
        }
        return run.get();
    }

}
