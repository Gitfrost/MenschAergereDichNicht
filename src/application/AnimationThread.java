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
	private final void auslösenListeners()
	{
		for (AnimationFertigListener listener : listeners)
		{
			listener.auslösenAnimationFertig(this);
		}
	}
	@Override
	public final void run()
	{
		try {doRun();}
		finally {auslösenListeners();}
	}
	public abstract void doRun();
}
