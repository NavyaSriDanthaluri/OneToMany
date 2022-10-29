package p1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="HospitalInfo")
@Entity
public class Hospital {
	
	@Id
	@GeneratedValue
	@Column(name = "HOSPITAL_ID")
	private @Getter @Setter int hospitalId;
	@Column(name = "HOSPITAL_NAME")
	private @Getter @Setter String hospitalName;
	@Column(name = "REGISTRATION_NUMBER")
	private @Getter @Setter String registrationNumber;
	
	//collection for doctors
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "HOSPITAL_ID")
	
	private @Getter @Setter List<Doctors> allDoctors;
	
	



	public Hospital(int hospitalId, String hospitalName, String registrationNumber) {
		
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.registrationNumber = registrationNumber;
		
	}
	
}
