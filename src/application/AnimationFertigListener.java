package application;

public interface AnimationFertigListener// Dieses Interface wird in der MainController Klasse implementiert.
{
	/*
	 * Diese Methode wird ausgef�hrt, sobald der AnimationThread abgeschlossen ist.
	 */
	void ausl�senAnimationFertig(final Thread thread);
}
