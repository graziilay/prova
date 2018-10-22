package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import entidades.Aluno;
import services.AlunoServico;

@ApplicationScoped
@Named
public class AlunoBean implements Serializable {

	@Inject
	private static final long serialVersionUID = 1L;
	private Aluno aluno = new Aluno();
	private Collection<Aluno> alunos;
	@Inject
	private AlunoServico service;

	@PostConstruct
	private void init() {
		setAlunos(service.getAll());
		setService(new AlunoServico());
	}

	public void salvarAluno() {
		service.save(aluno);
		aluno = new Aluno();

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public AlunoServico getService() {
		return service;
	}

	public void setService(AlunoServico service) {
		this.service = service;
	}

	public Collection<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}

}
