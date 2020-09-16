package tn.com.etap.EtapWorkers.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.com.etap.EtapWorkers.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);

	
	@Query("select w from AppUser w where w.nom like :x")
	public Page<AppUser> chercher(@Param("x")String mc, Pageable  pageable);


}
