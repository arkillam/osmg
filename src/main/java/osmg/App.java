package osmg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import osmg.beans.AppStrings;

/**
 * Class used to start up the Spring container, and make the application runnable.
 * 
 * Comment on beans: @ComponentScan(basePackages = "osmg") scans all packages under the base package "osmg".
 */

@Configuration
@ComponentScan(basePackages = "osmg")
public class App {

/**
 * instead of suppressing the "applicationContext is never closed" warning, I have made the field a private static field
 * (vs a variable defined in the main() function)
 */
private static AnnotationConfigApplicationContext applicationContext;

/**
 * @param args
 *            ignored
 */
public static void main(String[] args) {
	// get the application context (aka "start Spring container")
	if (applicationContext == null)
		applicationContext = new AnnotationConfigApplicationContext(App.class);

	// get the strings bean, use it to write out a "starting" message with the app's name
	AppStrings strings = applicationContext.getBean("appStrings", AppStrings.class);
	System.out.println(strings.getApplicationName() + " starting ...");

	// create the main window instance
	applicationContext.getBean("osmg", osmg.class);
}

}
