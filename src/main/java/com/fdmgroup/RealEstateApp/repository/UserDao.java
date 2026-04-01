package com.fdmgroup.RealEstateApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RealEstateApp.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

	User findByUserName(@Param("userName") String userName);

	User findByAccountType(@Param("accountType") String accountType);

	User deleteByUserId(@Param("userId") int userId);

	@Query("SELECT u FROM Users u WHERE u.accountType='SELLER'")
	List<User> getAllSellers();

	User findByEmail(@Param("email") String email);

}
