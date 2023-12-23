package br.com.faculdade.boleto.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.faculdade.boleto.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer>{

}
