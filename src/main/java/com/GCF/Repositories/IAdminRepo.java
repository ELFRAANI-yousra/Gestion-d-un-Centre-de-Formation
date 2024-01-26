package com.GCF.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Admin;

public interface IAdminRepo extends JpaRepository<Admin, Long>
{
	Optional<Admin> findByNomUtilisateur(String nomUtulisateur);

}
