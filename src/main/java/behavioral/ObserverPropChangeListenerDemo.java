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
	
	public ObserverPropChangeListenerDemo() {
		view = new MyView();
		model = new MyModel(); 
		model.addObserver(view);
	}

	public static void main(String[] av) {
		ObserverPropChangeListenerDemo me = new ObserverPropChangeListenerDemo();
		me.runTheMainApplication();
	}

	/** Represents the main part of an application */
	public void runTheMainApplication() {
		model.changeSomething("A new value");
		model.changeSomething("Another new value");
	}

	/** The Observer normally maintains a view on the data */
	class MyView implements PropertyChangeListener {
		/** For now, we just print the fact that we got notified. */
		@Override
		public void propertyChange(PropertyChangeEvent ev) {
			System.out.printf("update(%s->%s);\n", ev.getOldValue(), ev.getNewValue());
		}
	}

	/** The Observable normally maintains the data */
	class MyModel {
		PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
		String state = "Initial state";

		public void addObserver(PropertyChangeListener pcl) {
			propertyChangeSupport.addPropertyChangeListener(pcl);
		}

		public void changeSomething(String newValue) {
			// Notify observers of change
			propertyChangeSupport.firePropertyChange("something", state, newValue);
			state = newValue;
		}
	}
}
