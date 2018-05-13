package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class OneSwap2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String S;
		Stack stack;
		char arr[];
		while (T-- != 0) {
			S = br.readLine();
			arr = S.toCharArray();
			stack = new Stack<>();
			int mid = S.length() / 2;
			if("NO".equals(characterCount(S)))
					{
				System.out.println("No");
				continue;
					}
			for (int i = 0, j = S.length() - 1; i < mid && j>mid ; i++, j--) {
                 if(arr[i]==arr[j])
                	continue;
                 stack.push(i);
			}
			if(stack.isEmpty())
			{
			System.out.println("Yes");
			continue;
			}
			
			if(stack.size()==1)
				System.out.println("Yes");
			else if(stack.size()==2)
			{
				int popOne=(Integer)stack.pop();
				int popTwo=(Integer)stack.pop();
				if((arr[popOne]==arr[popTwo]) && arr[(S.length()-1)-popOne]==arr[(S.length()-1)-popTwo])
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			else
          System.out.println("No");
		}
	}

	
	static String characterCount(String inputString) {
		// Creating a HashMap containing char as a key and occurrences as a
		// value

		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		// Converting given string to char array

		char[] strArray = inputString.toCharArray();

		// checking each char of strArray

		for (char c : strArray) {
		if (charCountMap.containsKey(c)) {
		// If char is present in charCountMap, incrementing it's count
		// by 1

		charCountMap.put(c, charCountMap.get(c) + 1);
		} else {
		// If char is not present in charCountMap,
		// putting this char to charCountMap with 1 as it's value

		charCountMap.put(c, 1);
		}
		}

		// even case
		int oddcounter = 0;
		if (inputString.length() % 2 == 0) {
		for (char ch : charCountMap.keySet()) {
		if (charCountMap.get(ch) % 2 != 0) {
		return "NO";
		}
		}
		return "YES";
		}
		// odd case
		else {
		for (char ch : charCountMap.keySet())
		{
		if (charCountMap.get(ch) % 2 == 0) {
		continue;
		}
		else
		{
		oddcounter++;
		            if(oddcounter>1)
		            {
		            return "NO";
		            }
		}
		}
		           return "YES";

		}
		}

	
}
