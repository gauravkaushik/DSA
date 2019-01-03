package leetcode.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/decode-string/
========================================================================

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

public class DecodeString {
    public String decodeString(String s) {
        
        int N = s.length();
        Stack<String> stk = new Stack<>();
        LinkedList<String> list = new LinkedList<>();
        
        for(int i=0; i<N; i++)
        {            
            if(s.charAt(i) != ']')
                stk.push(s.charAt(i)+"");
            else
            {
                list.clear();
                while(!stk.peek().equals("["))
                {
                    list.offerFirst(stk.pop());
                }
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<list.size(); j++)
                    sb.append(list.get(j));
                    
                stk.pop();
                list.clear();
                
                l1:
                while(true)
                {
                    if(stk.isEmpty())
                        break l1;
                    try
                    {
                        Integer.parseInt(stk.peek());
                    }
                    catch(Exception e)
                    {
                        break l1;
                    }
                    list.offerFirst(stk.pop());
                }
                
                StringBuilder digits = new StringBuilder();
                for(int j=0; j<list.size(); j++)
                    digits.append(list.get(j));
                int count = Integer.parseInt(digits.toString());
                
                StringBuilder sb_new = new StringBuilder();
                while(count>0)
                {
                    sb_new.append(sb);
                    count--;
                }
                stk.push(sb_new.toString());
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!stk.isEmpty())
            res.insert(0, stk.pop());
        return res.toString();
        
    }
    
    private boolean isDigit(String i)
    {
        try
        {
            Integer.parseInt(i);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}