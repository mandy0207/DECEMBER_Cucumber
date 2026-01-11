package payLoads;

public class BookPayload {

	public  static String getAddBookPayload(String isbn, String aisle) {
		return 	"{ \r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn +"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	
	public static String deleteBookPayLoad(String id) {
		return "{\r\n"
				+ "\"ID\":\""+id+"\"\r\n"
				+ "}";
	}
}
