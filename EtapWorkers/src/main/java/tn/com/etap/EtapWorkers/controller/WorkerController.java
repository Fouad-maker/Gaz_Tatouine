package tn.com.etap.EtapWorkers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.com.etap.EtapWorkers.Dao.UserRepository;
import tn.com.etap.EtapWorkers.Service.AccountService;
import tn.com.etap.EtapWorkers.model.AppUser;

@RestController
public class WorkerController {
	
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


		
	
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		
		if(!userForm.getPassword().equals(userForm.getRepassword())) 
			throw new RuntimeException("you must confirm your password");
		AppUser user = accountService.findUserByUsername(userForm.getUsername());

		
		if(user != null) throw new RuntimeException("this user already exist");
		
		AppUser appUser = new AppUser();
		appUser.setPassword(userForm.getPassword());

		appUser.setUsername(userForm.getUsername());
		appUser.setNom(userForm.getNom());
		appUser.setPrenom(userForm.getPrenom());
		appUser.setEmail(userForm.getEmail());
		appUser.setTel(userForm.getTel());
		appUser.setDateBirdh(userForm.getDateBirdh());
		appUser.setPlaceOfBirth(userForm.getPlaceOfBirth());
		appUser.setSpeciality(userForm.getSpeciality());
		appUser.setOffice(userForm.getOffice());
		appUser.setQualification(userForm.getQualification());
		appUser.setDateRejointProjet(userForm.getDateRejointProjet());
		appUser.setAffected(userForm.isAffected());

		
		accountService.saveUser(appUser);
		accountService.addRoleToUser(userForm.getUsername(), "USER");

		 return appUser;
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/users" ,method = RequestMethod.GET)
	public List<AppUser> getUsers() {
		return  (List<AppUser>) userRepository.findAll();
				}
	
	/*************/
	
	
	
	@RequestMapping(value="/user/{id}" ,method = RequestMethod.GET)
	public Optional<AppUser> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
				}
	
	@RequestMapping(value="/use/{username}" ,method = RequestMethod.GET)
	public AppUser getUserByUsername(@PathVariable String username) {
		return userRepository.findByUsername(username);
				}
	
	/****************************/
	
	
	
	
	
	
	@RequestMapping(value="/chercherUsers" ,method = RequestMethod.GET)
	public Page<AppUser> chercherUser(
			@RequestParam(name = "mc",defaultValue = "")String mc , 
			@RequestParam(name = "page",defaultValue = "0")int page ,
			@RequestParam(name = "size",defaultValue = "5")int size ) {
		return userRepository.chercher("%"+mc+"%", PageRequest.of(page, size));
				}
	/********************************************************/
	
	
	
	
	
	@RequestMapping(value="/users" ,method = RequestMethod.POST)
	public AppUser saveUser(@RequestBody AppUser w) {
		return userRepository.save(w);
	}
	
	/***************************************************************************/
	
	
	
	@RequestMapping(value="/user/{id}" ,method = RequestMethod.DELETE)
	public boolean removeUser(@PathVariable Long id) {
		 userRepository.deleteById(id);
		 return true;
				}
	/********************************************************************************************/
	
	//update
	
	
	
	@RequestMapping(value="/users/{id}" ,method = RequestMethod.PUT)
	public AppUser updateUser(@PathVariable Long id,@RequestBody AppUser w) {
		w.setId(id);
		w.setPassword(bCryptPasswordEncoder.encode(w.getPassword()));
		return userRepository.save(w);
	}
	
	
	
	

}
