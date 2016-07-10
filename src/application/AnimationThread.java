package application;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Erzeugte Threads dieser Klasse koennen Listener ausloesen, sobald sie beendet sind.
 * Fuer diese Klasse und fuer das Interface diente folgende Quelle als Hilfestellung:
 * 
 * <a href="http://stackoverflow.com/questions/702415/how-to-know-if-other-threads-have-finished">Link</a>
 * 
 * @author Lucas Johns
 * @version 1.0
 */
public abstract class AnimationThread extends Thread
{
	/**
	 * Anlegen eines Sets fuer Listener, welches die AnimationFertigListener beinhaltet
	 */
	private final Set<AnimationFertigListener> listeners = new CopyOnWriteArraySet<AnimationFertigListener>();
	
	/**
	 * Methode zum Hinzufuegen eines Listeners
	 * @param listener Listener, der hinzugefuegt werden soll
	 */
	public final void addListener(final AnimationFertigListener listener)
	{
		listeners.add(listener);
	}
	/**
	 * Methode zum Entfernen eines Listeners
	 * @param listener Listener, der entfernt werden soll
	 */
	public final void removeListener(final AnimationFertigListener listener)
	{
		listeners.remove(listener);
	}
	/**
	 * Methode zum Ausloesen eines Listeners
	 */
	private final void ausloesenListeners()
	{
		for (AnimationFertigListener listener : listeners)
		{
			listener.ausloesenAnimationFertig(this);
		}
	}
	/**
	 * Nach Beendigung von doRun() wird der entsprechende Listener ausgeloest
	 * @see java.lang.Thread#run()
	 */
	@Override
	public final void run()
	{
		try {doRun();}
		finally {ausloesenListeners();}
	}
	public abstract void doRun();
}
