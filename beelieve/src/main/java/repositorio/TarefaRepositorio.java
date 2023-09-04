package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Tarefa;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long>{

}
