class Solution 
{
    public String minRemoveToMakeValid(String s) 
    {
        StringBuilder firstPass = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) 
        {
            if (c == '(') 
            {
                open++;
                firstPass.append(c);
            } 
            else if (c == ')')
            {
                if (open > 0) 
                {
                    open--;
                    firstPass.append(c);
                }
            } 
            else
            {
                firstPass.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        int close = 0;

        
        for (int i = firstPass.length() - 1; i >= 0; i--) 
        {
            char c = firstPass.charAt(i);
            if (c == ')') 
            {
                close++;
                result.append(c);
            } else if (c == '(')
            {
                if (close > 0)
                {
                    close--;
                    result.append(c);
                }
            } 
            else
            {
                result.append(c);
            }
        }

        return result.reverse().toString();
    }
}
