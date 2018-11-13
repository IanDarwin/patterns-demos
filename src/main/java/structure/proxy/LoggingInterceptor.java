package structure.proxy;

import java.lang.reflect.Field;
import java.util.List;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * A Logging Interceptor for CDI.
 * There's a fancier version using logging with SLF4J 
 * on GitHub at https://github.com/t1/logging-interceptor
 */
@Interceptor
public class LoggingInterceptor {

	public LoggingInterceptor() {
		// System.out.println("LoggingInterceptor.init()");
	}

	// @AroundInvoke applies to business method; see also @AroundTimeout for timeout methods, etc.
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Throwable {
		Object[] parameters = ctx.getParameters();
		String firstArg = (parameters.length > 0) ? "First is: " + format(parameters[0]) : "(empty)";
		log(String.format("About to call %s with %d arg(s): %s",
				ctx.getMethod().getName(), parameters.length, firstArg));
		Object o = ctx.proceed();	// The actual call!
		log("Returned " + format(o) + " from method " + ctx.getMethod().getName());
		return o;
	}
	
	/** Well, this part is no longer basic; format the argument list a bit */
	String format(Object o) {
		if (o instanceof String) {
			return (String)o;
		}
		if (o instanceof List) {
			int size = ((List<?>)o).size();
			return String.format("List(size %d): first is of type %s", size,
					size > 0 ? ((List<?>)o).get(0).getClass().getName() : "?");
		}
		if (o.getClass().isArray()) {
			Integer length = null;
			try {
				Field field = o.getClass().getField("length");
				length = (Integer)field.get(o);
			} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
				return "Array";
			}
			String base = o.getClass().getComponentType().getName();
			return String.format("Array length %d of %s", length, base);
		}
		return o.toString();
	}
	
	// Following is how it would normally be used; commented out b/c it can't
	// (or at least shouldn't!) be used on itself.

	// @Interceptors({LoggingInterceptor.class,LoggingInterceptor.class})
	public void validateCredit() {
		System.out.println("LoggingInterceptor.validateCredit(): I was here");
	}

	void log(String mesg) {
		System.out.println(mesg);
	}
}
