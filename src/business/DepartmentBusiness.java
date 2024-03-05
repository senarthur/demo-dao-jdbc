package business;

import java.sql.Connection;

import model.dao.ModelDao;
import model.entities.Department;

public class DepartmentBusiness extends BaseBusiness<Department> {

	private Connection conn = null;
	
	public DepartmentBusiness(ModelDao<Department> dao, Connection conn) {
		super(dao);
		this.conn = conn;
	}

	
}
