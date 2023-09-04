package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Projeto;

public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {

}
