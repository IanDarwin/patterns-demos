package structure.proxy;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class CdiDemoSe {

	public static void main(String[] args) {

		SeContainerInitializer initializer = SeContainerInitializer.newInstance();

		try (SeContainer container = initializer.initialize()) {
			final Instance<QuoteServer> selected = container.select(QuoteServer.class);
			// selected.forEach(System.out::println);
			QuoteServer qs = selected.get();
			System.out.println(qs.getQuote());
		}
	}
	@Produces
	public QuoteServer getQuoter() {
		return new QuoteServerImpl();
	}
}
