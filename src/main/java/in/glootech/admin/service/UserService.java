package in.glootech.admin.service;

import java.util.List;

import in.glootech.admin.entity.User;

public interface UserService {
	public Boolean saveUser(User user);
	public Boolean updateUser(Integer userId,User user);
	public List<User> getAllUser();
	public User getUserById(Integer userId);
	public Boolean changeStatus(Integer userId);
}
