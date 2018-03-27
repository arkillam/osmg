package osmg.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Contains strings used in the application, that I want to be able to easily find and change in one place. (This is a
 * singleton bean, written as such because I wanted to play with singleton bean injection, not because it makes sense to
 * store and access constants this way.)
 * 
 */

@Configuration
public class AppStrings {

/** handle for an instance of this singleton bean */
private static AppStrings strings = null;

/**
 * @return the singleton instance of this bean
 */
@Bean(name = "appStrings")
public static AppStrings getStrings() {
	if (strings == null)
		strings = new AppStrings();
	return strings;
}

/**
 * @return the application's name and version
 */
public final String getApplicationName() {
	return "Old School Mech Game 0.1";
}

}
