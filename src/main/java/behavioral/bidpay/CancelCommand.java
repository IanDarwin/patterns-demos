package behavioral.bidpay;

public class CancelCommand implements Command {
	Auction receiver;
	Client cancelBy;
	String cancelReason;

	public CancelCommand(Auction receiver, Client cnxer, String reason) {
		this.receiver = receiver;
		this.cancelBy = cnxer;
		this.cancelReason = reason;
	}
	public void execute() {
		receiver.cancel(cancelBy, cancelReason);
	}
}
