package structure.decorator;

import java.lang.reflect.Method;

public class TransactionInterceptorPseudoCode {
	
	UserTransaction transaction;    // Injected by the container
	
	// PSEUDO-CODE
	public void interceptTransaction(Method method, Object target, Object[] args) throws Exception {
	    if (transaction.getStatus() != Status.NoTransaction) {
	        transaction.begin();
	    }
	    try {
	        method.invoke(target, args);
	        transaction.commit();
	    } catch (Exception ex) {
	        transaction.rollback();
	        throw ex;
	    }
	}


	// Completely bogus, just to make the pseudo-code compile
	// Avoids depending on Java EE API just for this little bit.
	class UserTransaction {
		boolean exists() { return false; }
		void join() {}
		void begin() {}
		void commit() {}
		void rollback() {}
		int getStatus() { return 0; }
	}
	class Status {
		final static int NoTransaction = 0;
	}
}
