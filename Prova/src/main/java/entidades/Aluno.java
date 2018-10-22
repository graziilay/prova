package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno implements Identificavel {

	static private Long cont;
	@Id
	private Long id;
	private String nome;

	public Aluno() {
		this.id = cont;
		cont++;
	}

	public Aluno(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
