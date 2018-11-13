package structure.proxy;

/** The interface that the impl and the proxy both implement. */
public interface QuoteServer {
	/** Serve up a randomly-chosen quote */
	public String getQuote();
	/** Admin tool to add quotes */
	public void addQuote(String newQuote);
}

