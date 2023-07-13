package DataStructure;

import java.util.Stack;

// leetcode 20
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()[]]{}"));
	}

	private static  boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for(char ch : s.toCharArray()) {
			if ("[({".contains(String.valueOf(ch))) {
				stack.push(ch);
			} else {
				if (stack.size() == 0)  return false ;
				Character popped = stack.pop();
				if (!isMatched(popped, ch))  return false ;

			}
		}

		return stack.size()  == 0 ;
	}

	private static boolean isMatched(char open, char close) {
		if (open == '(' && close == ')') return true;
		if (open == '[' && close == ']') return true;
		if (open == '{' && close == '}') return true;

		return false;
	}

}


