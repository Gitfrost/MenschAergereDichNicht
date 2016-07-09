package application;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * Erzeugte Threads dieser Klasse k�nnen Listener ausl�sen, sobald sie beendet sind.
 * F�r diese Klasse und f�r das Interface diente folgende Quelle als Hilfestellung:
 * 
 * http://stackoverflow.com/questions/702415/how-to-know-if-other-threads-have-finished#
 */
public abstract class AnimationThread extends Thread
{
	/*
	 * Anlegen eines Sets fuer Listener, welches die AnimationFertigListener beinhaltet
	 */
	private final Set<AnimationFertigListener> listeners = new CopyOnWriteArraySet<AnimationFertigListener>();
	
	/*
	 * Methode zum Hinzuf�gen eines Listeners
	 */
	public final void addListener(final AnimationFertigListener listener)
	{
		listeners.add(listener);
	}
	/*
	 * Methode zum Entfernen eines Listeners
	 */
	public final void removeListener(final AnimationFertigListener listener)
	{
		listeners.remove(listener);
	}
	/*
	 * Methode zum Ausl�sen eines Listeners
	 */
	private final void ausloesenListeners()
	{
		for (AnimationFertigListener listener : listeners)
		{
			listener.ausloesenAnimationFertig(this);
		}
	}
	/*
	 * �berschreiben
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
