package com.jsp.playme.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.jsp.playme.model.Admin;

public interface AdminService
{
	boolean checkAdminLogin(String mail, String password);

	boolean storeData(Map<String, Object> album, Map<String, Object> track, Map<String, Object> artist, MultipartFile trackImage, MultipartFile audio, MultipartFile artistImage);
}
