package structure.proxy;

import javax.interceptor.Interceptors;

/** Simple non-working example of Transaction annotations */
public class ShoppingService {
	private ShoppingCart cart;
	private Dao dao;

	@Transactional(TransactionType.REQUIRED)
	public void addToCart(Product p) {
		// do validation/calculation work here
		dao.saveCart(cart);
	}
	
	@Interceptors({CdiLoggingInterceptor.class})
	public void validateCredit() {
	    // do some work here
	}
	
	// Stuff below here is totally bogus, just to make
	// the above example compile.
	enum TransactionType { REQUIRED, REQUIRES_NEW }
	@interface Transactional {
		TransactionType value();
	}
	class ShoppingCart {
		// empty
	}
	class Product {
		// empty
	}
	class Dao {
		void saveCart(ShoppingCart cart) {
			// empty
		}
	}
}
