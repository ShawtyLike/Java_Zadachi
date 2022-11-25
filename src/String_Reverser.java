public class String_Reverser{
    String stringToReverse;

    public String_Reverser(String string)
    {
        this.stringToReverse = string;

    }

    public String Reverser_Type1(){
        for (int i = stringToReverse.length()-1; i >= 0 ; i--)
        {
            stringToReverse = stringToReverse + stringToReverse.charAt(i);
        }
        stringToReverse = stringToReverse.substring(stringToReverse.length()/2);
        return stringToReverse;
    }

    public String Reverser_Type2()
    {

        String newstring = "";
        for (int i = stringToReverse.length()-1; 1 <= i+1; i--) {
            newstring += "" + stringToReverse.charAt(i);
        }
        return newstring;
    }


    public static void main(String[] args) {
        String_Reverser string_reverser = new String_Reverser("123456");
        String_Reverser string_reverser1= new String_Reverser("654321");
        String a = string_reverser.Reverser_Type1();
        String b = string_reverser1.Reverser_Type2();
        System.out.println(a);
        System.out.println(b);
    }
}