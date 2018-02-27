package behavioral.bidpay;

public class BidCommand implements Command {
	Auction receiver;
	double amount;
	Client bidder;

	public BidCommand(Auction receiver, double amount, Client bidder) {
		this.receiver = receiver;
		this.amount = amount;
		this.bidder = bidder;
	}
	public void execute() {
		receiver.bid(amount, bidder);
	}
}
