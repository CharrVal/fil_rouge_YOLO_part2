package bll;

import java.util.List;

import Exception.RoleException;
import bo.Role;
import dal.RoleDAO;

public class RoleBLL {
	private RoleDAO dao;
	
	public RoleBLL() {
		dao = new RoleDAO();
	}
	
	public List<Role> select() {
		return dao.select();
	}
	
	public Role selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Role Role) throws RoleException {
		//verifier(Role);
		dao.insert(Role);
	}

	public void delete(Role Role) {
		dao.delete(Role);
	}

	public void update(Role Role) throws RoleException {
		// verifier(Role);
		dao.update(Role);
	}

}
