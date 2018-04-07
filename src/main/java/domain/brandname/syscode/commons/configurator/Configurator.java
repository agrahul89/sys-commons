package domain.brandname.syscode.commons.configurator;

import javax.annotation.PostConstruct;

public interface Configurator {

	long DEFAULT_RELOAD_MS = 180000;

	@PostConstruct
	public void configure();

}
