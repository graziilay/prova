package entidades;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma implements Identificavel {

	static private Long cont;
	@Id
	private Long id;
	private String nome;
	@OneToMany
	private Set<Disciplina> disciplinas;

	public Turma() {
		this.id = cont;
		cont++;
	}

	public Turma(Long id, String nome, Set<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.disciplinas = disciplinas;
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

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
