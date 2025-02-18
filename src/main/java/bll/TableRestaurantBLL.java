package bll;

import java.util.List;

import Exception.TableRestaurantException;
import bo.TableRestaurant;
import dal.TableRestaurantDAO;

public class TableTableRestaurantBLL {
	private TableRestaurantDAO dao;
	
	public TableRestaurantBLL() {
		dao = new TableRestaurantDAO();
	}
	
	public List<TableRestaurant> select() {
		return dao.select();
	}
	
	public TableRestaurant selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(TableRestaurant TableRestaurant) throws TableRestaurantException {
		//verifier(TableRestaurant);
		dao.insert(TableRestaurant);
	}

	public void delete(TableRestaurant TableRestaurant) {
		dao.delete(TableRestaurant);
	}

	public void update(TableRestaurant TableRestaurant) throws TableRestaurantException {
		// verifier(TableRestaurant);
		dao.update(TableRestaurant);
	}

}
