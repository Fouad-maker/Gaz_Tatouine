package tn.com.etap.EtapWorkers.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.etap.EtapWorkers.model.AppRole;


public interface RoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRoleName(String roleName);

}
