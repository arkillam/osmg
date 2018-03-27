package osmg;

import javax.swing.JFrame;

/**
 * The "main" class of the application, holds all of the objects that are used to play the game.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import osmg.beans.AppStrings;

@Component
public class osmg extends JFrame {

private static final long serialVersionUID = 1L;

/** holds ... wait for it ... strings (see Strings class for details) */
private AppStrings appStrings;

/**
 * The one and only constructor. Because we are going to use injected beans, this class uses bean injection via
 * constructor instead of setters.
 * 
 * @param appStrings
 *            see Strings class for details
 */
public osmg(@Autowired AppStrings appStrings) {
	super();
	this.appStrings = appStrings;

	// referencing using a "this" to avoid the "field never used" warnings that I will keep getting until more strings
	// are added and referenced outside of the constructor
	setTitle(this.appStrings.getApplicationName());

	setLocation(0, 0);
	setSize(1024, 768);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}

}
