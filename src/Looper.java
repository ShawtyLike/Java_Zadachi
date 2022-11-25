import java.util.ArrayList;
import java.util.Arrays;

public class Looper
{

    ArrayList<String> a;

    public Looper(ArrayList<String> ListOfStrings)
    {
        this.a = ListOfStrings;
    }

    public void PerformAnAction(String s)
    {
        //as an example action im going to put System.out.println
        System.out.println(s);
    }
    public void Iterate_Using_For()
    {
        for (String ab:a) {
            PerformAnAction(ab);
        }
    }
    public void Iterate_Using_While()
    {
        int i = 0 ;
        while(i<a.size())
        {
            PerformAnAction(a.get(i));
            i++;
        }
    }
    public static void main(String[] args)
    {
        Looper arraylist = new Looper(new ArrayList<>(Arrays.asList("dog", "mouse")));
        arraylist.Iterate_Using_For();
        arraylist.Iterate_Using_While();
    }

}
