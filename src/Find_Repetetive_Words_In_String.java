import java.util.ArrayList;
import java.util.HashMap;

public class Find_Repetetive_Words_In_String
{
    String stringToSearchIn;
    HashMap hm;
    Boolean IgnoreCaseSensetivity;
    public Find_Repetetive_Words_In_String(String string,HashMap hm,Boolean IgnoreCaseSensetivity)
    {
        this.stringToSearchIn = string;
        this.hm = hm;
        this.IgnoreCaseSensetivity = IgnoreCaseSensetivity;
    }

    public ArrayList<String> ConvertStringToList()
    {
        ArrayList<String>  ListOfWords = new ArrayList<String>();
        for (int i = 0 ; i<stringToSearchIn.split(" ").length;i++){
            if(IgnoreCaseSensetivity)
            ListOfWords.add(stringToSearchIn.split(" ")[i].toLowerCase());
        else
            {
                ListOfWords.add(stringToSearchIn.split(" ")[i]);
            }
        }
        return ListOfWords;
    }

    public Boolean IsItemAlreadyInHM(String item1)
    {

        if (hm.get(item1) ==null){
            return false;
        }else{
            return true;
        }
    }

    public HashMap CountWordsAndReturnMap() {
        int lengthOfWordList = ConvertStringToList().size();
        for (int i = 0; i < lengthOfWordList; i++) {
            String CurrentlyIteratedWord = ConvertStringToList().get(i);

            if (IsItemAlreadyInHM(CurrentlyIteratedWord)) {
                hm.put(CurrentlyIteratedWord, (Integer) hm.get(CurrentlyIteratedWord)+1);
            }
            else {
                hm.put(CurrentlyIteratedWord, 1);
            }

        }return hm;
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        Find_Repetetive_Words_In_String ab = new Find_Repetetive_Words_In_String("Horse horse man woman horse man",hm,false);
        System.out.println(ab.CountWordsAndReturnMap());
    }

}
