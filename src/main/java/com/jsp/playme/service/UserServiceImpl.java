package com.jsp.playme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.playme.model.User;
import com.jsp.playme.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository uRepo;

	@Override
	public User addNewUser(User user)
	{
		try
		{
			User u = uRepo.save(user);
			if (u != null)
			{
				return u;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean checkEmail(String mail)
	{
		try
		{
			User user = uRepo.findByuseremail(mail);
			if (user != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean checkMobile(String mobile)
	{
		try
		{
			User user = uRepo.findByusermobile(mobile);
			if (user != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public User checkMailLogin(String mail, String password)
	{
		try
		{
			User user = uRepo.findByUseremailAndUserpassword(mail, password);
			if (user != null)
			{
				return user;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public User checkMobileLogin(String mobile, String password)
	{
		try
		{
			User user = uRepo.findByUsermobileAndUserpassword(mobile, password);
			if (user != null)
			{
				return user;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

}
