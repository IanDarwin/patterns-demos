package creation.builder;

public class Play {
    int id;
    String job;
    String firstName;
    String lastName;

    /** This is the main constructor, used from the Builder */
    private Play(PlayBuilder b) {
    	this.id = b.id;
    	this.job = b.job;
    	this.firstName = b.firstName;
    	this.lastName = b.lastName;
    }
    
    /** 
     * This constructor is left here, non-public, just to show the "old way";
     * in real life it should be removed, or marked private and called only
     * from the Builder.build() method
     */
    Play(int id,
            String job,
            String firstName,
            String lastName) {
        this.id = id;
        this.job = job;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /** The builder is here as a nested class so it can use the private constructor */
    public static class PlayBuilder {
        private int id;
        private String job;
        private String firstName;
        private String lastName;

    	private PlayBuilder() {
    		// We control construction
    	}

    	public static PlayBuilder builder() {
    		return new PlayBuilder();
    	}

        public PlayBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PlayBuilder job(String job) {
            this.job = job;
            return this;
        }

        public PlayBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PlayBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Play build() {
            return new Play(this);
        }
    }
}
