package in.glootech.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import in.glootech.admin.entity.User;
import in.glootech.admin.repository.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public Boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateUser(Integer userId, User user) {
        try {
            User existingUser = userRepository.findById(userId).orElse(null);
            if (existingUser != null) {
                BeanUtils.copyProperties(user,existingUser);
                userRepository.save(existingUser);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
    	
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Boolean changeStatus(Integer userId) {
        try {
            User existingUser = userRepository.findById(userId).orElse(null);
            if (existingUser != null) {
                // Toggle user status
                existingUser.setActiveStatus(!existingUser.getActiveStatus());
                userRepository.save(existingUser);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
