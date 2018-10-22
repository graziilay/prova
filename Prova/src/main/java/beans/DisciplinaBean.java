package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Disciplina;
import entidades.Professor;
import services.DisciplinaServico;

@ApplicationScoped
@Named
public class DisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Disciplina disciplina = new Disciplina();
	private Collection<Disciplina> disciplinas;

	@Inject
	private DisciplinaServico servico;

	@ManagedProperty(value = "#{professorBean}")
	private ProfessorBean professorBean;

	@PostConstruct
	private void init() {
		servico = new DisciplinaServico();
	}

	private void salvarDisc() {
		for (Professor professor : professorBean.getProf()) {
			if (disciplina.getProfessor().getId() == professor.getId()) {
				disciplina.setProfessor(professor);
			}
		}
		servico.save(disciplina);
		disciplina = new Disciplina();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public DisciplinaServico getService() {
		return servico;
	}

	public void setService(DisciplinaServico service) {
		this.servico = service;
	}

	public Collection<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
