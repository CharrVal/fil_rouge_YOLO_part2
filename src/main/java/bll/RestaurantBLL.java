package bll;

import java.util.List;

import Exception.RestaurantException;
import bo.Restaurant;
import dal.RestaurantDAO;

public class RestaurantBLL {
	private RestaurantDAO dao;
		
//		public RestaurantBLL() {
//			dao = new RestaurantDAO();
//		}
		
		public List<Restaurant> select() {
			dao = new RestaurantDAO();
			return dao.select();
		}
		
		public Restaurant selectById(int id) {
			return dao.selectById(id);
		}
		
		public void insert(Restaurant restaurant) throws RestaurantException {
			//verifier(restaurant);
			dao.insert(restaurant);
		}
	
		public void delete(Restaurant restaurant) {
			dao.delete(restaurant);
		}
	
		public void update(Restaurant restaurant) throws RestaurantException {
			// verifier(restaurant);
			dao.update(restaurant);
		}
}
