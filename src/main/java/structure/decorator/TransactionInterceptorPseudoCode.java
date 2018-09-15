package structure.decorator;

import java.lang.reflect.Method;

public class TransactionInterceptorPseudoCode {
	
	UserTransaction transaction;    // Injected by the container
	
    // PSEUDO-CODE
    public void interceptTransaction(Method method, Object target, Object[] args) throws Exception {
        if (transaction.exists()) {
            transaction.join();
        } else {
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
    
    
    // Completely bogus, just to make the pseuqo-code compile
    class UserTransaction {
    	boolean exists() { return false; }
    	void join() {}
    	void begin() {}
    	void commit() {}
    	void rollback() {}
    }
}
