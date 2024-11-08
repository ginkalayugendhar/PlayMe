package com.jsp.playme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.playme.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByuseremail(String mail);

	User findByusermobile(String mobile);

	User findByUseremailAndUserpassword(String mail, String password);

	User findByUsermobileAndUserpassword(String mobile, String password);

}
