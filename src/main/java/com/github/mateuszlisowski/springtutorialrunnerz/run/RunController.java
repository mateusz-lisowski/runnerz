package com.github.mateuszlisowski.springtutorialrunnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RunController {

    private final RunRepository repository;

    public RunController(RunRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    String root() {
        return "root";
    }

    @GetMapping("run")
    List<Run> getAllRuns() {
        return repository.getAllRuns();
    }
}
