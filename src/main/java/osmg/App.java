package osmg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import osmg.beans.Strings;

/**
 * Main application.
 * 
 * Comment on beans: @ComponentScan(basePackages = "osmg") scans all packages under the base package "osmg".
 */

@Configuration
@ComponentScan(basePackages = "osmg")
public class App {

public static Strings strings;

public static void main(String[] args) {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);

	strings = applicationContext.getBean("strings", Strings.class);
	System.out.println(strings.getApplicationName() + " starting ...");

	// create the main window instance
	osmg main = applicationContext.getBean("osmg", osmg.class);
}

}
