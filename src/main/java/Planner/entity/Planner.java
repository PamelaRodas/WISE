package Planner.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "planners")
public class Planner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference("usuario-planner")
    private Usuario usuario;

    @OneToMany(mappedBy = "planner", cascade = CascadeType.ALL)
    @JsonManagedReference("planner-journal")
    private List<Journal> journals;

    public Planner() {
    }

    public Planner(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }
}

