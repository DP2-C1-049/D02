
package acme.entities.flightassignment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightAssignment extends AbstractEntity {

	// Serialisation version ----------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ---------------------------------------------------------------

	//	Comentado hasta que se cree la entidad FlightCrewMember
	//	@Mandatory
	//	@Automapped
	//	@Valid
	//	@ManyToOne
	//	private FlightCrewMember	flightCrewMember;

	// Comentado hasta qye se cree la entidad leg
	//	@Mandatory
	//	@Automapped
	//	@Valid
	//	@ManyToOne
	//	private Leg					leg;

	@Mandatory
	@Automapped
	@Valid
	private Duty				duty;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	@Mandatory
	@Automapped
	@Valid
	private CurrentStatus		currentStatus;

	@Optional
	@Automapped
	@ValidString
	private String				remarks;

}
