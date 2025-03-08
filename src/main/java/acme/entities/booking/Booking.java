
package acme.entities.booking;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends AbstractEntity {

	//Serialisation identifier -----------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes --------------------------------------------------------------------------

	//Commented until creating the consumer entity
	//	@Mandatory
	//	@Automapped
	//	@Valid
	//	@ManyToOne
	//	private Customer customer;

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z0-9]{6,8}$")
	private String				locatorCode;

	@Mandatory
	@Automapped
	@ValidMoment(past = true)
	private Date				purchaseMoment;

	@Mandatory
	@Automapped
	@Valid
	private TravelClass			travelClass;

	@Mandatory
	@Automapped
	@ValidMoney
	private Money				price;

	@Optional
	@Automapped
	private String				lastNibble;


	//ENUM --------------------------------
	public enum TravelClass {
		ECONOMY, BUSINESS
	}
}
