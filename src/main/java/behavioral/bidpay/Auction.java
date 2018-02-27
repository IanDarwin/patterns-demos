package behavioral.bidpay;

import java.util.*;

/**
 * This represents one item that is up for auction on a bidding site like eBay.com.
 * Code is very simplistic, and is also not thread safe.
 */
public class Auction {
	String description;
	double minBid;
	Client seller;
	Bid highBid;
	List<Bid> bids = new ArrayList<>();
	// If canceled
	Client cancelBy;
	String cancelReason;

	private class Bid {
		double amount;
		Client bidder;
		Bid(double amount, Client bidder) {
			this.amount = amount;
			this.bidder = bidder;
		}
	}

	public Auction(String description, Client seller, double minBid) {
		this.description = description;
		this.seller = seller;
		this.minBid = minBid;
	}

	public void bid(double amount, Client bidder) {
		if (amount < minBid) {
			System.out.printf("REJECT bid from %s for %s, must be %.2f\n", bidder, this.description, amount);
			return;
		}
		if (cancelBy != null) {
			System.out.printf("REJECT bid from %s for CANCELED auction %s\n", bidder, this.description);
			return;
		}
		bids.add(new Bid(amount, bidder));
		Bid highBid = null;
		double highBidAmt = 0;
		for (Bid bid : bids) {
			if (bid.amount > highBidAmt) {
				highBidAmt = bid.amount;
				highBid = bid;
			}
		}
		this.highBid = highBid;
	}

	public void cancel(Client cnxer, String reason) {
		this.cancelBy = cnxer;
		this.cancelReason = reason;
	}

	public String toString() {
		return String.format("%s's Auction of %s: high bid %.2f by %s",
			seller.name, description, highBid.amount, highBid.bidder);
	}
}
