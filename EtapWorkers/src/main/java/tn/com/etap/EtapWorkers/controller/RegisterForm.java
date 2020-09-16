package tn.com.etap.EtapWorkers.controller;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data

public class RegisterForm {
	private String username;
	private String password;
	private String repassword;
	private String nom;
	private String prenom;
	private String email;
	private long tel;
	
	private String placeOfBirth;
	private String speciality;
	private String office;
	private String qualification;
	private boolean affected;
	@Temporal(TemporalType.DATE)
	private Date dateRejointProjet;
	@Temporal(TemporalType.DATE)
	private Date dateBirdh;
	

}
