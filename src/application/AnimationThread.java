package application;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * http://stackoverflow.com/questions/702415/how-to-know-if-other-threads-have-finished#
 */
public abstract class AnimationThread extends Thread
{
	private final Set<AnimationFertigListener> listeners = new CopyOnWriteArraySet<AnimationFertigListener>();
	
	public final void addListener(final AnimationFertigListener listener)
	{
		listeners.add(listener);
	}
	
	public final void removeListener(final AnimationFertigListener listener)
	{
		listeners.remove(listener);
	}
	private final void ausl�senListeners()
	{
		for (AnimationFertigListener listener : listeners)
		{
			listener.ausl�senAnimationFertig(this);
		}
	}
	@Override
	public final void run()
	{
		try {doRun();}
		finally {ausl�senListeners();}
	}
	public abstract void doRun();
}
