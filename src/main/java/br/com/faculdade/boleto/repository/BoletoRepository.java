package br.com.faculdade.boleto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdade.boleto.entity.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Long>{

}
