package behavioral.bidpay;

/**
 * A Client can buy, sell, or both.
 */
public class Client {
	String name;
	public Client(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
