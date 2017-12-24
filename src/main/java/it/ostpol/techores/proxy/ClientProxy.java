package it.ostpol.techores.proxy;

import it.ostpol.techores.TechOreBlocks;
import it.ostpol.techores.TechOreItems;

public class ClientProxy implements Proxy {

	@Override
	public void init() {
		TechOreBlocks.registerRenders();
		TechOreItems.registerRenders();
	}

}
