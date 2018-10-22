package services;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import dao.AlunoDAO;
import entidades.Aluno;
import util.TransacionalCdi;

@ApplicationScoped
public class AlunoServico implements Serializable, Service<Aluno> {

	private static final long serialVersionUID = -7803325791425670859L;

	@Inject
	private AlunoDAO userDAO;

	@Override
	@TransacionalCdi
	public void save(Aluno user) {
		userDAO.save(user);
	}

	@Override
	@TransacionalCdi
	public void update(Aluno user) {
		userDAO.update(user);
	}

	@Override
	@TransacionalCdi
	public void remove(Aluno user) {
		userDAO.remove(user);
	}

	@Override
	public Aluno getByID(long userId) {
		return userDAO.getByID(userId);
	}

	@Override
	public List<Aluno> getAll() {
		return userDAO.getAll();
	}

}
