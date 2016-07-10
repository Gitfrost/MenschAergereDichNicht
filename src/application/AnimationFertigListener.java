package application;

/**
 * Dieses Interface wird in der MainController Klasse implementiert.
 * Folgende Quelle diente als Hilfestellung:
 * 
 * <a href="http://stackoverflow.com/questions/702415/how-to-know-if-other-threads-have-finished">Link</a>
 * 
 * @author Lucas Johns
 * @version 1.0
 */
public interface AnimationFertigListener
{
	/**
	 * Diese Methode wird ausgefuehrt, sobald der AnimationThread abgeschlossen ist.
	 * @param thread Thread, der nach seiner Beendigung den Listener ausloest
	 */
	void ausloesenAnimationFertig(final Thread thread);
}
