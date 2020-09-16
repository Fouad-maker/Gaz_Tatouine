package tn.com.etap.EtapWorkers.Service;


import tn.com.etap.EtapWorkers.model.AppRole;
import tn.com.etap.EtapWorkers.model.AppUser;

public interface AccountService {
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);
	

}
