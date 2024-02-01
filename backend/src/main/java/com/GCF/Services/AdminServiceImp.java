package com.GCF.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Admin;
import com.GCF.Repositories.IAdminRepo;
@Service
public class AdminServiceImp implements AdminService
{

	@Autowired
	IAdminRepo a;
	@Override
	public Admin creatAdmin(Admin admin) {
		
		return a.save(admin) ;
	}
	

}
