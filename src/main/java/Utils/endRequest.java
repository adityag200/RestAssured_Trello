package Utils;

public class endRequest {
	public static String board() {
		String resource = "/1/boards/";
		return resource;
	}

	public static String card() {

		String resource = "/1/cards/";
		return resource;
	}

	public static String addCardLabel(String label) {

		String resource = "/1/cards/" + label + "/labels/";
		return resource;
	}
	
	public static String lists() {

		String resource = "/1/lists/";
		return resource;
	}

}
