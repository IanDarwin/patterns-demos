package behavioral;

import java.beans.*;

/**
 * A simple demo of Observable->Observer using JavaBeans PropertyChangeListener
 *
 * @author Ian Darwin
 */
public class ObserverPropChangeListenerDemo extends Object {
	MyView view;
	MyModel model;

	public static void main(String[] av) {
		ObserverPropChangeListenerDemo me = new ObserverPropChangeListenerDemo();
		me.runTheMainApplication();
	}

	public ObserverPropChangeListenerDemo() {
		view = new MyView();
		model = new MyModel(); 
		model.addObserver(view);
	}

	public void runTheMainApplication() {
		model.changeSomething();
	}

	/** The Observer normally maintains a view on the data */
	class MyView implements PropertyChangeListener {
		/** For now, we just print the fact that we got notified. */
		public void propertyChange(PropertyChangeEvent ev) {
			System.out.printf("update(%s->%s);\n", ev.getOldValue(), ev.getNewValue());
		}
	}

	/** The Observable normally maintains the data */
	class MyModel {
		PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

		public void addObserver(PropertyChangeListener pcl) {
			propertyChangeSupport.addPropertyChangeListener(pcl);
		}

		public void changeSomething() {
			// Notify observers of change
			propertyChangeSupport.firePropertyChange("something", "old value", "Hello New Value");
		}
	}
}
