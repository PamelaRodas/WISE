package Planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import Planner.entity.Journal;
import Planner.repository.JournalRepository;

@RestController
@RequestMapping("/journals")
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    @PostMapping
    public Journal crear(@RequestBody Journal journal) {
        return journalRepository.save(journal);
    }

    @GetMapping
    public List<Journal> obtenerTodos() {
        return journalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Journal obtenerPorId(@PathVariable Long id) {
        return journalRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        journalRepository.deleteById(id);
    }
}