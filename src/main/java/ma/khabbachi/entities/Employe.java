package ma.khabbachi.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table (name = "employe")
public class Employe {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Temporal (TemporalType.DATE)
	private Date dateNaissance;
	private String photo;
	
	@ManyToOne
	private Servece services;
	
	@ManyToOne
	@JsonIgnore
	private Employe employes;

	public Employe() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Servece getServices() {
		return services;
	}

	public void setServices(Servece services) {
		this.services = services;
	}

	public Employe getEmployes() {
		return employes;
	}

	public void setEmployes(Employe employes) {
		this.employes = employes;
	}

	


	

	
	
	
	

}