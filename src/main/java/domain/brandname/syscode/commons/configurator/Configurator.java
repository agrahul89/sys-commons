package domain.brandname.syscode.commons.configurator;

import javax.annotation.PostConstruct;

public interface Configurator {

	@PostConstruct
	public void configure();

}
