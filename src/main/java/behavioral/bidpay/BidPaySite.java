package behavioral.bidpay;

public class BidPaySite {
	public static void main(String[] args) {
		new BidPaySite().process();
	}

	static final Client[] clients = {
		new Client("BidPay Site"),
		new Client("MaryBeth"),
		new Client("Keener"),
		new Client("El Cheapo"),
	};

	static final Auction[] auctions = {
		new Auction("Persian Rug", clients[1], 1000),
		new Auction("Mac Computer", clients[2], 1000),
		new Auction("Nikon D850", clients[2], 4000),
		new Auction("Tesla Model 3", clients[2], 50000),
	};

	void process() {
		System.out.println("BidPaySite V -1.-1.-1 here...");
		sendSomeDemoBids();
		evaluateWinners();
	}
	public void sendSomeDemoBids() {
		submitCommand(new BidCommand(auctions[0], 1001, clients[1]));
		submitCommand(new BidCommand(auctions[3], 30000, clients[3]));
		submitCommand(new CancelCommand(auctions[3], clients[0], "Above your pay grade"));
		submitCommand(new BidCommand(auctions[3], 50000, clients[3]));
	}

	/** IRL the real clients would invoke this method */
	public void submitCommand(Command command) {
		command.execute();
	}

	public void evaluateWinners() {
		for (Auction a : auctions) {
			if (a.highBid == null) {
				System.out.printf("UNSOLD: %s's auction of %s did not get %.2f\n",
					a.seller, a.description, a.minBid);
			} else {
				System.out.println("Will sell: " + a);
			}
		}
	}
}
