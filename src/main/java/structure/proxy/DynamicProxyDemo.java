package structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

/**
 * Simple demo of Java SE's "dynamic proxy" mechanism.
 * Dynamic proxies allow you to create an implementation of
 * an interface without having to know the class name,
 * providing more flexibility.
 * @author Ian Darwin
 */
public class DynamicProxyDemo {

	/** Here we show the whole thing in operation. */
	public static void main(String[] args) {

		// Proxy is commonly used with some kind of creational method which
		// the client calls to obtain the "real" object but actually gets
		// the proxied object, the proxy must therefore be substituable
		// for the real object
		QuoteServer quoteServer = getQuoteServer();

		System.out.println("QuoteServer object is " + quoteServer.getClass().getName());
		quoteServer.addQuote("Only the educated are free -- Epictetus");
		System.out.println("QuoteServer returned: " + quoteServer.getQuote());
	}

	public static QuoteServer getQuoteServer() {
		QuoteServer target = new QuoteServerImpl();
		InvocationHandler handler = new MyInvocationHandler(target);
		return (QuoteServer) Proxy.newProxyInstance(
			QuoteServer.class.getClassLoader(),
            new Class[] { QuoteServer.class }, handler);
	}

	/** The InvocationHandler, called whenever any method on the proxy is invoked.
	 * Note that the invoke() method only needs a reference to the implementation
	 * object; it does not (necessarily) need to figure out which method to call,
	 * because it's passed a Method descriptor.
	 */
	static class MyInvocationHandler implements InvocationHandler {

		private Object target;

		public MyInvocationHandler(Object target) {
			super();
			this.target = target;
		}

		/**
		 * Method that is called for every call into the proxy;
		 * this has to invoke the method on the real object.
		 * This method demonstrates both logging and security checking.
		 */
		public Object invoke(Object proxyObject, Method method, Object[] argList)
			throws Throwable {
			String name = method.getName() + "()";
			System.out.println("Proxy got request for " + name); // or your favorite logging package
			final String userName = System.getProperty("user.name");
			if (name.startsWith("add") && !userName.equals("ian"))
				throw new SecurityException("User " + userName + " not allowed to add quotes.");
			Object ret = method.invoke(target, argList);
			System.out.println("Proxy returned from " + name);
			return ret;
		}
	}
}
