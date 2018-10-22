package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Turma;
import services.TurmaServico;

@ApplicationScoped
@Named
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Turma turma = new Turma();
	private Collection<Turma> turmas;

	@Inject
	private TurmaServico service;

	public Turma getTurma() {
		return turma;
	}

	public void salvarTurma() {

	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}

	public TurmaServico getService() {
		return service;
	}

	public void setService(TurmaServico service) {
		this.service = service;
	}

	@PostConstruct
	private void init() {

	}

	public Collection<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Collection<Turma> turmas) {
		this.turmas = turmas;
	}
}
