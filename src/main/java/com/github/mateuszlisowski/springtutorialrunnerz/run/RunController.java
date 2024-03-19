package com.github.mateuszlisowski.springtutorialrunnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("")
    Run createRun(@RequestBody Run run) {
        return repository.createRun(run);
    }

    @PutMapping("/{id}")
    Run updateRun(@RequestBody Run run, @PathVariable Integer id) {
        return repository.updateRun(run, id);
    }

    @DeleteMapping("/{id}")
    void deleteRun(@PathVariable Integer id) {
        Optional<Run> runToDelete = repository.getRunByID(id);
        if (runToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run with id " + id + " does not exist");
        }
        repository.deleteRun(runToDelete.get());
    }

}
