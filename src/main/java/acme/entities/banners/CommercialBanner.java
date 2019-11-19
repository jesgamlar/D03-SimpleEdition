
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommercialBanner extends DomainEntity {

	//Serialisation identifier ----------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ------------------------------------------

	@URL
	@NotBlank
	private String				picture;

	@URL
	@NotBlank
	private String				url;

	@NotBlank
	private String				slogan;

	@NotBlank
	@Pattern(regexp = "5[1-5][0-9]{14}$")
	private String				creditCard;

}
