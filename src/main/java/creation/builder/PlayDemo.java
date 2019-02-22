package creation.builder;

public class PlayDemo {
	// Traditional construction - note 3 Strings in a row, easy to get order wrong
	Play p1 = new Play(1, "Hoverboardist", "Robin", "Smith");

	// Builder construction - more verbose, but far less chance of data in wrong field.
    Play p2 = Play.PlayBuilder.builder()
    		.id(1)
    		.job("Hoverboardist")
    		.firstName("Robin")
    		.lastName("Smith").build();
}
