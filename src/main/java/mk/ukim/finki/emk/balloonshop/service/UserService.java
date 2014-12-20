package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.model.User;

public interface UserService {

	public void addUser(User u);

	public void deleteUser(int id);

	public void updateUser(User u);

	public User getUser(int id);

	public List<User> getAllUsers();

	public boolean signInUser(User user, HttpSession session);
}
