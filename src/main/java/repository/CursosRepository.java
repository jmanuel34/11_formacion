package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Curso;

public interface CursosRepository extends JpaRepository<Curso, Integer> {

}
