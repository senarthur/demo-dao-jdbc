package business;

import java.util.List;

import model.dao.ModelDao;

public class BaseBusiness<T> {
	
	protected ModelDao<T> dao;
	
	public BaseBusiness(ModelDao<T> dao) {
		this.dao = dao;
	}

	public void insert(T obj) {
		dao.insert(obj);
	}

	public void update(T obj) {
		dao.update(obj);
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public T findById(Integer id) {
		return dao.findById(id);
	}

	public List<T> findAll() {
		return dao.findAll();
	}
	
}
