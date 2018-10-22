package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Professor;
import services.ProfessorServico;

@ApplicationScoped
@Named
public class ProfessorBean implements Serializable {

	@Inject
	private ProfessorServico service;
	private String confirmSenha;
	private static final long serialVersionUID = 1L;
	private Professor professor = new Professor();
	private Collection<Professor> prof;

	@PostConstruct
	private void init() {
		service = new ProfessorServico();
	}

	public Collection<Professor> getProf() {
		return prof;
	}

	public void setProfs(Collection<Professor> prof) {
		this.prof = prof;
	}

	public void salvarProf() {
		if (!professor.getSenha().equals(confirmSenha)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "As senhas n�o conferem!"));
		} else {
			boolean sameLogin = false;
			for (Professor p : prof) {
				if (professor.getEmail().equals(p.getEmail())) {
					sameLogin = true;
				}
			}
			if (sameLogin) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("ERROR", "Login j� esta cadastrado"));
			} else {
				service.save(professor);
				professor = new Professor();
			}
		}

	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setProfs(Set<Professor> profs) {
		this.prof = prof;
	}

	public ProfessorServico getService() {
		return service;
	}

	public void setService(ProfessorServico service) {
		this.service = service;
	}

	public String getConfirmSenha() {
		return confirmSenha;
	}

	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}

	{

	}
}
