package tn.com.etap.EtapWorkers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AppUser {
	
	

	@Id @GeneratedValue
	private Long id;
	@Column(unique = true)
	private String username;
	
	private String password;
	
	
			
	
	  private String nom;
	  private String prenom;
	  private String email;
	  private long tel;
	  
	  @Temporal(TemporalType.DATE)
	  private Date dateBirdh;
	  @Temporal(TemporalType.DATE)
	  private Date dateRejointProjet;
	  
	  private String placeOfBirth;
	  private String speciality;
	  private String office;
	  private String qualification;
	  private String state;
	  private boolean affected;
	  
	  @ManyToMany(fetch = FetchType.EAGER)
		private Collection<AppRole> roles =new ArrayList<>();
		
		
	  
	  
	
	

	//@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	
	
	/*public Worker(String nom, String prenom, Date dateOfBirdh  
	,String placeOfBirth, String email, long tel,Date dateRejointProject , String state,
	String qualification,String speciality,String username, String password) 
{
super();
this.username=username;
this.password=password;
this.nom = nom;
this.prenom = prenom;
this.dateBirdh = dateOfBirdh;
this.placeOfBirth = placeOfBirth;
this.email = email;
this.tel = tel;
this.dateRejointProjet = dateRejointProject;
this.state=state;
this.qualification=qualification;
this.speciality=speciality;

}*/

	

	
}
