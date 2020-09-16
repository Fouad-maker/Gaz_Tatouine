package tn.com.etap.EtapWorkers.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.com.etap.EtapWorkers.Dao.RoleRepository;
import tn.com.etap.EtapWorkers.Dao.UserRepository;
import tn.com.etap.EtapWorkers.model.AppRole;
import tn.com.etap.EtapWorkers.model.AppUser;


@Service
@Transactional
public class AccountServiceImp implements AccountService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public AppUser saveUser(AppUser appUser) {
		String hashPW = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(hashPW);
		
		return userRepository.save(appUser);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser appUser = userRepository.findByUsername(username);
		AppRole role = roleRepository.findByRoleName(roleName);
		appUser.getRoles().add(role);
		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
