package io.github.agrahul89.commons.configurator;

import javax.annotation.PostConstruct;

public interface Configurator {

	@PostConstruct
	public void configure();

}
