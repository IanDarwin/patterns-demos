package structure.decorator;

public class ImageSales {

	/** 
	 * Create and print some images in various degrees of decoratedness.
	 * IRL this code would probably be in a Factory pattern implementation.
	 */
	public static void main(String[] args) {
		// Create an un-decorated image
		final PhotoImage image = new PhotoImage("Sunset at Tres Rios", "2020/ifd12345.jpg");

		// Make a print of that, on usletter paper
		Print im1 = new Print(11, 8.5, image);
		addToPrintOrder(im1);

		// Make a 19x11 print of a second image, matted in green, framed.
		Print im2 = 
			new Print(19, 11,
				new Frame(
					new Mat("Lime Green",
						new PhotoImage("Goodbye at the Station", "1987/ifd.00042.jpg"))));
		addToPrintOrder(im2);

		// Make a digital print sale
		PhotoImage dig = new DigitalImage(image, StockAgency.Getty, 135.00);
		System.out.println(dig);
	}

	private static void addToPrintOrder(Print image) {
		System.out.println(image);
	}
}
