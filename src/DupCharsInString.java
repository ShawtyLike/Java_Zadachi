public class DupCharsInString
{
    public static void main(String[] args) {
        String string = "aabbc";
        char arrayOfChars[] = string.toCharArray();
        for (int i = 0; i < string.length(); i++)
        {
            int count = 0;
            for (int n = 0; n < string.length(); n++)
            {
                if (arrayOfChars[i] == arrayOfChars[n]){
                    count++;
                    if(count>1) arrayOfChars[n]=' ';
                }
            }if(count>1 && arrayOfChars[i]!=' ')System.out.println(arrayOfChars[i]);
        }

    }

}
