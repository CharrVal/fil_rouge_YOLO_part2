package dal;

import java.util.List;

public interface DAO<T> {
	List<T> select();
	T selectById(int id);
	void update(T data);
	void insert(T data);
	void delete(T data);
	T deletebyId(int id);
}
