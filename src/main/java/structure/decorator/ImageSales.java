package structure.decorator;

public class ImageSales {

	/** 
	 * Create and print some images in various degrees of decoratedness.
	 * IRL this code would probably be in a Factory pattern implementation.
	 */
	public static void main(String[] args) {
		// Create an un-decorated image
		final PhotoImage image = new PhotoImage("Sunset at Tres Rios", "2020/ifd12345.jpg");
		System.out.println(image);
		
		// Make a print of that, on usletter paper
		PhotoImage im1 = new Print(image, 11, 8.5);
		System.out.println(im1);
		
		// Make a 19x11 print of a second image, matted in green, framed.
		PhotoImage im2 = 
			new Frame(
				new Mat(
					new Print(
						new PhotoImage("Goodbye at the Station", "1987/ifd.00042.jpg"), 19, 11), 
					"Lime Green"));
		System.out.println(im2);
		
		// Make a digital print sale
		PhotoImage dig = new DigitalImage(image, StockAgency.Getty, 135.00);
		System.out.println(dig);
	}
}
