package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.User;

public interface UserDao {

	public void addUser(User u);

	public void deleteUser(int id);

	public void updateUser(User u);

	public User getUser(int id);

	public List<User> getAllUsers();

	public User getUserByEmail(String email);

	public User checkCredentials(String email, String password);

	public List<User> search(String keyword);

	public List<User> getUsersInRange(int from, int max, String keyword);

	public int getUsersCount(String keyword);
}
