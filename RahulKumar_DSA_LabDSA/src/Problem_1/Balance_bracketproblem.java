package Problem_1;

import java.util.*;

public class Balance_bracketproblem {

	Stack<Character> stack = new Stack<>();

	public void Brackets(String strArr) {
		int balance = StringToArray(strArr);
		if (balance == 0)
			System.out.println("The entered String has Balanced Brackets");
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

	public int StringToArray(String strArr) {
		int balance = 0;
		for (int i = 0; i < strArr.length(); i++) {

			char f = strArr.charAt(i);

			if (f == '(' || f == '[' || f == '{') {

				stack.push(f);
				balance = balance + 1;
				continue;
			} else {

				if (f == ')') {
					f = '(';
				}
				if (f == ']') {
					f = '[';
				}
				if (f == '}') {
					f = '{';
				}

				char popBracket = stack.pop();
				if (popBracket == f) {
					balance = balance - 1;
				} else

					break;

			}

		}

		return balance;
	}

	
}
