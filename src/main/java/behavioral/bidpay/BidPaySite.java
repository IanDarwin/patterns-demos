package behavioral.bidpay;

public class BidPaySite {
	public static void main(String[] args) {
		new BidPaySite().process();
	}

	/** A non-static control method */
	void process() {
		System.out.println("----- BidPaySite V -1.-1.-1 here... -----");
		fakeClientSendSomeBids();
		printBidStatuses();
	}

	/** Fake list of Clients */
	static final Client[] clients = {
		new Client("BidPay Site"),
		new Client("MaryBeth"),
		new Client("Ian"),
		new Client("Keener"),
		new Client("El Cheapo"),
		new Client("ScamOMatic"),
	};

	/** Fake list of auctions */
	static final Auction[] auctions = {
		new Auction("Persian Rug", clients[1], 1000),
		new Auction("Mac Computer", clients[2], 1000),
		new Auction("Nikon D850", clients[3], 4000),
		new Auction("Tesla Model 3", clients[5], 50000),
	};

	/** The name of this method tells you what's going on */
	public void fakeClientSendSomeBids() {
		submitCommand(new BidCommand(auctions[0], 1001, clients[2]));
		submitCommand(new BidCommand(auctions[3], 30000, clients[4]));
		submitCommand(new CancelCommand(auctions[3], clients[0], "Above your pay grade"));
		submitCommand(new BidCommand(auctions[3], 50000, clients[4]));
	}

	/** IRL the real clients would invoke this method directly */
	public void submitCommand(Command command) {
		// These could go into a queue to serialize them, or we could make sure
		// that the methods exposed to the Command are all thread-safe.
		command.execute();
	}

	public void printBidStatuses() {
		System.out.println("----- Current Status -----");
		for (Auction a : auctions) {
			System.out.println(a);
		}
	}
}
