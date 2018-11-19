package structure.proxy;

/**
 * Simple demo of a manually-built proxy
 * @author Ian Darwin
 */
public class SimpleProxyDemo {

	/** Here we show the whole thing in operation. */
	public static void main(String[] args) {

		// Proxy is commonly used with some kind of creational method which
		// the client calls to obtain the "real" object but actually gets
		// the proxied object, the proxy must therefore be substituable
		// for the real object
		QuoteServer quoteServer = getQuoteServer();
		System.out.println("QuoteServer object is " + quoteServer.getClass().getName());
		quoteServer.addQuote("Only the educated are free -- Epictetus");
		System.out.println("The quote of the day is: " + quoteServer.getQuote());
	}

	public static QuoteServer getQuoteServer() {
		final QuoteServer target = new QuoteServerImpl();
		QuoteServer proxy = new QuoteServer() {
			public String getQuote() {
				System.out.println("Calling getQuote()");
				return target.getQuote();
			}
			public void addQuote(String newQuote) {
				// Could put security checking here
				System.out.println("Calling addQuote()");
				target.addQuote(newQuote);
			}
		};
		return proxy;
	}
}
