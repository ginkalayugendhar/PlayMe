package com.jsp.playme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.playme.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>
{

	Admin findByAdminemailAndAdminpassword(String adminemail, String adminpassword);

}
