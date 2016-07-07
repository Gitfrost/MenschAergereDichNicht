package application;

public interface AnimationFertigListener// Dieses Interface wird in der MainController Klasse implementiert.
{
	/*
	 * Diese Methode wird ausgeführt, sobald der AnimationThread abgeschlossen ist.
	 */
	void auslösenAnimationFertig(final Thread thread);
}
