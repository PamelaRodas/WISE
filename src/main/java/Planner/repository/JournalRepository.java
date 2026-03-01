package Planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Planner.entity.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}