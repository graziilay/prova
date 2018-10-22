package services;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import dao.TurmaDAO;
import entidades.Turma;
import util.TransacionalCdi;

@ApplicationScoped
public class TurmaServico implements Serializable, Service<Turma> {

	private static final long serialVersionUID = -7803325791425670859L;

	@Inject
	private TurmaDAO userDAO;

	@Override
	@TransacionalCdi
	public void save(Turma user) {
		userDAO.save(user);
	}

	@Override
	@TransacionalCdi
	public void update(Turma user) {
		userDAO.update(user);
	}

	@Override
	@TransacionalCdi
	public void remove(Turma user) {
		userDAO.remove(user);
	}

	@Override
	public Turma getByID(long userId) {
		return userDAO.getByID(userId);
	}

	@Override
	public List<Turma> getAll() {
		return userDAO.getAll();
	}

}
