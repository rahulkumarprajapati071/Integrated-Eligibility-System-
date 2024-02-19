package in.glootech.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.glootech.admin.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
