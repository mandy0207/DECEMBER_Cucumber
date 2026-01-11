package utils;

import com.github.javafaker.Faker;

public class UniqueGenerator {

	public static Faker getFaker() {
	return new Faker();
	
	}
	
	public static String getBookName() {
		return getFaker().book().title();
		
	}
	
	public static String getISbn() {
		return getFaker().internet().password();
		
	}
	
	public static String getAisle() {
		return getFaker().number().digits(5);
		
	}
	
	public static String getAuthorName() {
		return getFaker().book().author();
	}
}
