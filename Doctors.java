package p1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Doctors {
	
	@Id
	@GeneratedValue
	@Column(name = "DOCTOR_ID")
	private @Getter@Setter int doctorId;
	@Column(name = "DOCTOR_NAME")
	private @Getter@Setter String doctorName;
	@Column(name = "DOCTOR_SPECIFICATION")
	private @Getter@Setter String doctorSpecification;
	

}
