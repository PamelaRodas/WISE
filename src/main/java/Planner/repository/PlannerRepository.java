package Planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Planner.entity.Planner;

public interface PlannerRepository extends JpaRepository<Planner, Long> {
}