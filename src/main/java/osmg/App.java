package osmg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import osmg.beans.Strings;

/**
 * Class used to start up the Spring container, and make the application runnable.
 * 
 * Comment on beans: @ComponentScan(basePackages = "osmg") scans all packages under the base package "osmg".
 */

@Configuration
@ComponentScan(basePackages = "osmg")
public class App {

/**
 * @param args
 *            ignored
 */
public static void main(String[] args) {
	// get the application context (aka "start Spring container")
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);

	// get the strings bean, use it to write out a "starting" message with the app's name
	Strings strings = applicationContext.getBean("strings", Strings.class);
	System.out.println(strings.getApplicationName() + " starting ...");

	// create the main window instance
	osmg main = applicationContext.getBean("osmg", osmg.class);
}

}
