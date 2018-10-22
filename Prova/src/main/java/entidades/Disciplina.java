package entidades;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Identificavel {

	static private Long cont;
	@Id
	private Long id;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	@OneToMany
	private Set<Aluno> alunos;

	public String getNome() {
		return nome;
	}

	public Disciplina() {
		this.id = cont;
		cont++;
	}

	public Disciplina(Long id, String nome, Professor professor, Set<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
		this.alunos = alunos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

}
