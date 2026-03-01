package Planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Planner.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}