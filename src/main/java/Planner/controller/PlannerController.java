package Planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import Planner.entity.Planner;
import Planner.repository.PlannerRepository;

@RestController
@RequestMapping("/planners")
public class PlannerController {

    @Autowired
    private PlannerRepository plannerRepository;

    @PostMapping
    public Planner crear(@RequestBody Planner planner) {
        return plannerRepository.save(planner);
    }

    @GetMapping
    public List<Planner> obtenerTodos() {
        return plannerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Planner obtenerPorId(@PathVariable Long id) {
        return plannerRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        plannerRepository.deleteById(id);
    }
}
