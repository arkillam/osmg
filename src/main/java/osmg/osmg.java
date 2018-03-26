package osmg;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import osmg.beans.Strings;

@Component
public class osmg extends JFrame {

private static final long serialVersionUID = 1L;

/** holds ... wait for it ... strings */
private Strings strings;

/**
 * The one and only constructor. Because we are going to use injected beans, this class uses bean injection via
 * constructor instead of setters.
 * 
 * @param strings
 *            see Strings class for details
 */
public osmg(@Autowired Strings strings) {
	super(strings.getApplicationName());
	this.strings = strings;

	setLocation(0, 0);
	setSize(1024, 768);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}

}
