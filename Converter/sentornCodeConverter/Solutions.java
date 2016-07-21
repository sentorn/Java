package sentorn.conv;

public class Solutions {

	String twoToEight(String text) {
		if (!text.equals("")) {
			String res = twoToTen(text);
			return tenToEight(res);
		} else {
			return "";
		}
	}

	String twoToTen(String text) {
		if (!text.equals("")) {
			String textRes = invert(text);
			int res = 0;
			for (int i = 0; i < textRes.length(); i++) {
				if (textRes.charAt(i) == '1') {
					res = res + (int) Math.pow(2, i);
				}
			}
			return String.valueOf(res);
		} else {
			return "";
		}
	}

	String twoToSixteen(String text) {
		if (!text.equals("")) {
			String res = twoToTen(text);
			return tenToSixteen(res);
		} else {
			return "";
		}
	}

	String eightToTwo(String text) {
		if (!text.equals("")) {
			String res = "";
			for (int i = 0; i < text.length(); i++) {
				res = res
						+ eightToThreeChars(Integer.parseInt(""
								+ text.charAt(i)));
			}
			String res1 = "";
			for (int i = 0; i < res.length(); i++) {
				if (res.charAt(i) == '1') {
					res1 = res.substring(i);
					i = res.length();
				}
			}
			return res1;
		} else {
			return "";
		}
	}

	String eightToTen(String text) {
		if (!text.equals("")) {
			String res = eightToTwo(text);
			return twoToTen(res);
		} else {
			return "";
		}
	}

	String eightToSixteen(String text) {
		if (!text.equals("")) {
			String res = eightToTwo(text);
			return twoToSixteen(res);
		} else {
			return "";
		}
	}

	String tenToTwo(String text) {
		if (!text.equals("")) {
			int num = Integer.parseInt(text);
			String res = "";
			while (num > 0) {
				res = res + num % 2;
				num = num / 2;
			}
			return invert(res);
		} else {
			return "";
		}
	}

	String tenToEight(String text) {
		if (!text.equals("")) {
			int num = Integer.parseInt(text);
			String res = "";
			while (num > 0) {
				res = res + num % 8;
				num = num / 8;
			}
			return invert(res);
		} else {
			return "";
		}
	}

	String tenToSixteen(String text) {
		if (!text.equals("")) {
			int num = Integer.parseInt(text);
			String res = "";
			while (num > 0) {
				if (num % 16 == 15) {
					res = res + "F";
				}
				if (num % 16 == 14) {
					res = res + "E";
				}
				if (num % 16 == 13) {
					res = res + "D";
				}
				if (num % 16 == 12) {
					res = res + "C";
				}
				if (num % 16 == 11) {
					res = res + "B";
				}
				if (num % 16 == 10) {
					res = res + "A";
				}
				if (num % 16 < 10) {
					res = res + num % 16;
				}
				num = num / 16;
			}
			return invert(res);
		} else {
			return "";
		}
	}

	String sixteenToTwo(String text) {
		if (!text.equals("")) {
			String res = "";
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == 'A') {
					res = res + sixteenToFourChars(10);
				}
				if (text.charAt(i) == 'B') {
					res = res + sixteenToFourChars(11);
				}
				if (text.charAt(i) == 'C') {
					res = res + sixteenToFourChars(12);
				}
				if (text.charAt(i) == 'D') {
					res = res + sixteenToFourChars(13);
				}
				if (text.charAt(i) == 'E') {
					res = res + sixteenToFourChars(14);
				}
				if (text.charAt(i) == 'F') {
					res = res + sixteenToFourChars(15);
				}
				if (Character.isDigit(text.charAt(i))) {
					res = res
							+ sixteenToFourChars(Integer.parseInt(""
									+ text.charAt(i)));
				}
			}
			String res1 = "";
			for (int i = 0; i < res.length(); i++) {
				if (res.charAt(i) == '1') {
					res1 = res.substring(i);
					i = res.length();
				}
			}
			return res1;
		} else {
			return "";
		}
	}

	String sixteenToEight(String text) {
		if (!text.equals("")) {
			String res = sixteenToTwo(text);
			return twoToEight(res);
		} else {
			return "";
		}
	}

	String sixteenToTen(String text) {
		if (!text.equals("")) {
			String res = sixteenToTwo(text);
			return twoToTen(res);
		} else {
			return "";
		}
	}

	String invert(String text) {
		String res = "";
		for (int i = text.length() - 1; i >= 0; i--) {
			res = res + text.charAt(i);
		}
		return res;
	}

	String eightToThreeChars(int a) {
		String res = tenToTwo(String.valueOf(a));
		if (a == 0) {
			res = "000";
		}
		if (res.length() == 1) {
			res = "00" + res;
		}
		if (res.length() == 2) {
			res = "0" + res;
		}
		return res;
	}

	String sixteenToFourChars(int a) {
		String res = tenToTwo(String.valueOf(a));
		if (a == 0) {
			res = "0000";
		}
		if (res.length() == 1) {
			res = "000" + res;
		}
		if (res.length() == 2) {
			res = "00" + res;
		}
		if (res.length() == 3) {
			res = "0" + res;
		}
		return res;
	}

}
