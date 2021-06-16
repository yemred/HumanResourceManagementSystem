package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cirriculum_vitaes")
public class CirriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="github_address")
	private String githubAdress;
	
	@Column(name="linkedin_address")
	private String linkedinAdress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(mappedBy = "cirriculumVitae")
	private List<ProgrammingLanguage> programmingLanguages;
	
	@OneToMany(mappedBy = "cirriculumVitae")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "cirriculumVitae")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "cirriculumVitae")
	private List<Language> languages;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	


}
