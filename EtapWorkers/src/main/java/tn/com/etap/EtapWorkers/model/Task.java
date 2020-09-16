package tn.com.etap.EtapWorkers.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
	@Id @GeneratedValue
	private Long id;
	private String taskName;
	private int duresApproximative;
	private String description;
	private Date dateOfAffectaion;
	@OneToOne(fetch = FetchType.EAGER)
	private AppUser workerTask ;
	
}	
