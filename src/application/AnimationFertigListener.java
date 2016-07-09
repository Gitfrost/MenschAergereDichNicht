package application;

/*
 * Für dieses Interface und die Klasse AnimationFertigListener diente folgende Quelle als Hilfestellung:
 * 
 * http://stackoverflow.com/questions/702415/how-to-know-if-other-threads-have-finished#
 */
public interface AnimationFertigListener// Dieses Interface wird in der MainController Klasse implementiert.
{
	/*
	 * Diese Methode wird ausgeführt, sobald der AnimationThread abgeschlossen ist.
	 */
	void ausloesenAnimationFertig(final Thread thread);
}
