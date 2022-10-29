package p1;
import java.util.List;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Kid {

	    private @Getter @Setter String dob;
	    @Column(name="Kid_Name")
	    private @Getter @Setter String name;
	    private @Getter @Setter String gender;
	    private @Getter @Setter int weight;
	    @Id
	    private @Getter @Setter int id;
	    @Embedded
	    @Getter @Setter    Parent parentInfo;
	    @Embedded
		@AttributeOverrides({
		      @AttributeOverride(name = "fatherName", column = @Column(name = "grandFather")),
		      @AttributeOverride(name = "motherName", column = @Column(name = "grandMother")),
		      @AttributeOverride(name = "phoneNumber", column = @Column(name = "gPhoneNumber")),

		})

	    @Getter @Setter Parent grandParentInfo;
	    @ElementCollection
		@CollectionTable(name = "VaccinationCertificates")
		private @Getter @Setter List<Vaccination> vaccinationCard;
	   
	    @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "HospitalInfo")
		private @Getter @Setter Hospital hospitalInfo;
	    
	    
		public Kid(String dob, String name, String gender, int weight) {
			super();
			this.dob = dob;
			this.name = name;
			this.gender = gender;
			this.weight = weight;
		}

	}
