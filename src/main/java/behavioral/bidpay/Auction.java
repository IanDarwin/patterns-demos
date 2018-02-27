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

	public boolean isCancelled() {
		return cancelBy != null;
	}

	/** Submit a bid */
	public void bid(double amount, Client bidder) {
		if (amount < minBid) {
			System.out.printf("REJECT bid from %s for %s, must be %.2f\n", bidder, description, amount);
			return;
		}
		if (isCancelled()) {
			System.out.printf("REJECT bid from %s for CANCELED auction %s\n", bidder, description);
			return;
		}
		bids.add(new Bid(amount, bidder));
		System.out.printf("Accepted bid of %.2f from %s for auction of %s\n", amount, bidder, description);
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

	/** Cancel an Auction, irrevocably */
	public void cancel(Client cnxer, String reason) {
		this.cancelBy = cnxer;
		this.cancelReason = reason;
	}

	public String toString() {
		if (isCancelled()) {
			return String.format("CANCELLED: %s's auction of %s", seller, description);
		}
		if (highBid == null) {
			return String.format("UNSOLD: %s's auction of %s did not get %.2f",
				seller, description, minBid);
		} else {
			return String.format("Will Sell: %s's auction of %s, high bid %.2f",
				seller, description, highBid.amount);
		}
	}
}
