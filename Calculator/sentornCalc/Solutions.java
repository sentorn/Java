package com.sentornCalc;

import java.util.Stack;

public class Solutions {

	String removeLastChar(String str) {
		if (str.length() > 1) {
			return str.substring(0, str.length() - 1);
		} else {
			return "0";
		}
	}

	char last(String text) {
		return text.charAt(text.length() - 1);
	}

	String inputDot(String text) {
		if (Character.isDigit(text.charAt(text.length() - 1))
				&& !text.contains(".")) {
			return text + ".";
		}
		if (text.substring(text.lastIndexOf(".") + 1).contains("+")
				&& Character.isDigit(text.charAt(text.length() - 1))
				|| text.substring(text.lastIndexOf(".") + 1).contains("-")
				&& Character.isDigit(text.charAt(text.length() - 1))
				|| text.substring(text.lastIndexOf(".") + 1).contains("*")
				&& Character.isDigit(text.charAt(text.length() - 1))
				|| text.substring(text.lastIndexOf(".") + 1).contains("/")
				&& Character.isDigit(text.charAt(text.length() - 1))) {
			return text + ".";
		}
		if (isBracket(last(text)) || isOperator(last(text))) {
			return text;
		} else {
			return text;
		}
	}

	String inputDigit(String text, String dig) {
		if (text.equals("0")) {
			return dig;
		}
		if (last(text) == ')') {
			return text;
		} else {
			return text + dig;
		}
	}

	String inputOpenBracket(String text) {
		if (isOperator(last(text))) {
			return text + "(";
		} else {
			return text;
		}
	}

	String inputCloseBracket(String text) {
		if (text.equals("0")) {
			return "0";
		}
		if (Character.isDigit(text.charAt(text.length() - 1))
				&& text.contains("(")) {
			return text + ")";
		} else {
			return text;
		}
	}

	String inputMinusOperator(String text) {
		if (text.equals("0")) {
			return "-";
		}
		if (isOperator(last(text)) || last(text) == '.') {
			return text;
		} else {
			return text + "-";
		}
	}

	String inputOtherOperators(String text, String op) {
		if (text.equals("0")) {
			return "0";
		}
		if (isOperator(last(text)) || last(text) == '.' || last(text) == '(') {
			return text;
		} else {
			return text + op;
		}
	}

	boolean sameBracketCount(String str) {

		int countOpen = 0;
		int countClose = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				countOpen++;
			}
			if (str.charAt(i) == ')') {
				countClose++;
			}
		}
		return countOpen == countClose;
	}

	boolean isBracket(char br) {
		return br == '(' || br == ')';
	}

	boolean isOperator(char op) {
		return op == '+' || op == '-' || op == '*' || op == '/';
	}

	int getPriority(char op) {
		if (op == '*' || op == '/') {
			return 2;
		}
		if (op == '+' || op == '-') {
			return 1;
		} else {
			return -1;
		}
	}

	void arithmeticResult(Stack<Double> stack, char op) {
		double r = stack.pop();
		double l = 0;
		if (!stack.isEmpty()) {
			l = stack.pop();
		} else {
			l = 0;
		}

		if (op == '+') {
			stack.push(l + r);
		}
		if (op == '-') {
			stack.push(l - r);
		}
		if (op == '*') {
			stack.push(l * r);
		}
		if (op == '/') {
			stack.push(l / r);
		}

	}

	private Stack<Double> stackD = new Stack<Double>();
	private Stack<Character> stackC = new Stack<Character>();

	String mainMethod(String str) {
		stackD.clear();
		stackC.clear();

		if (last(str) == '(' || last(str) == '.' || !sameBracketCount(str) || isOperator(last(str))) {
			return str;
		} else {

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stackC.push('(');
				}
				if (str.charAt(i) == ')') {
					while (stackC.peek() != '(') {
						arithmeticResult(stackD, stackC.pop());
					}
					stackC.pop();
				}
				if (isOperator(str.charAt(i))) {
					while (!stackC.isEmpty()
							&& getPriority(stackC.peek()) >= getPriority(str
									.charAt(i))) {
						arithmeticResult(stackD, stackC.pop());
					}
					stackC.push(str.charAt(i));
				}
				if (Character.isDigit(str.charAt(i))) {
					String dig = "";
					while (i < str.length() && Character.isDigit(str.charAt(i))
							|| i < str.length() && str.charAt(i) == '.') {
						dig += str.charAt(i++);
					}
					--i;
					stackD.push(Double.parseDouble(dig));
				}

			}
			while (!stackC.isEmpty()) {
				arithmeticResult(stackD, stackC.pop());
			}
			String res = String.valueOf(stackD.get(0));
			if (res.charAt(res.indexOf(".") + 1) == '0') {
				return res.substring(0, res.indexOf("."));
			} else {
				return res;
			}
		}
	}
}
