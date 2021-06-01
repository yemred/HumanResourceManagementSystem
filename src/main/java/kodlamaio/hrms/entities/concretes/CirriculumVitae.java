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
	
	@OneToMany(mappedBy = "cirriculum_vitaes")
	private List<ProgrammingLanguage> programmingLanguages;
	
	@OneToMany(mappedBy = "cirriculum_vitaes")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "cirriculum_vitaes")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "cirriculum_vitaes")
	private List<Language> languages;
	
	@ManyToOne()
	@JoinColumn(name="un_employed_user_id")
	private UnEmployedUser unEmployedUser;
	


}
