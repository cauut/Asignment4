package vn.ifisolution.fresher12.util;

import java.util.UUID;

public class GenUuid {
	public static String random() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
