package cn.chiv.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.chiv.entity.User;
import cn.chiv.repository.MyRepository;


public interface UserRepository extends MyRepository<User, Long> {

	@Query("from User where username = :username and password = :password")
	User login(@Param("username") String username, @Param("password") String password);

}
