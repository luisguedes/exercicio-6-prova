package br.com.proj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.MessageFormat;

@Entity
public class Cad {

	public static final String QUERY_ALL = "Chat.All";

	@Id
	@GeneratedValue
	private int codigo;
	private String nome;
	private String cpf;
	// private double porcentcacau;

	public Cad() {
	}

	public Cad(int codigo, String nome, String cpf) { // double porcentcacau) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		// this.setPorcentcacau(porcentcacau);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return cpf;
	}

	public void setTipo(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("{0} - {1}", nome, cpf);
	}

	/*
	 * / public double getPorcentcacau() { return porcentcacau; }
	 * 
	 * public void setPorcentcacau(double porcentcacau2) { this.porcentcacau =
	 * porcentcacau2; } /
	 */

}
