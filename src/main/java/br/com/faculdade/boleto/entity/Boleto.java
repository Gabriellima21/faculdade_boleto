package br.com.faculdade.boleto.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity(name = "boleto_aluno")
public class Boleto {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(name = "alunoId",nullable = false)
	 private Aluno idAluno;
	 @Column(name = "valor",nullable = false)
	 private Double valor;
	 @Column(name = "dataVencimento",nullable = false,length = 10)
	 private LocalDate dataVencimento;
	 @Column(name="pago",nullable = false,length = 5)
	 private Boolean pago;
	 @Column
	 private Integer codigo;
	 
	public Aluno getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Aluno idAluno) {
		this.idAluno = idAluno;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return idAluno;
	}
	public void setAluno(Aluno aluno) {
		this.idAluno = aluno;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public boolean getPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	} 
}
