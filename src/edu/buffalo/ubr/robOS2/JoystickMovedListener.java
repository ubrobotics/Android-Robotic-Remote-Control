package edu.buffalo.ubr.robOS2;
/**
 * This code was "stolen" from the Moble Anarchy Widgets project, and is used
 * under the New BSD License.
 * 
 * Mobile Anarchy Widgets Site: http://code.google.com/p/mobile-anarchy-widgets/
 */
public interface JoystickMovedListener {
	public void OnMoved(int pan, int tilt);
	public void OnReleased();
	public void OnReturnedToCenter();
}
