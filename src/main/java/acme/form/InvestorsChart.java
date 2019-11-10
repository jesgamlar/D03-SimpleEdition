
package acme.form;

import java.io.Serializable;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvestorsChart implements Serializable {

	//Serialisation Identifier------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ------------------------------------------

	Collection<String>			sectors;

	Collection<Integer>			investorsBySector;

}
