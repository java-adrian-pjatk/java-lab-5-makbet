// autorzy Adrian Witkowski
//         Filip Bianga
// data wykonania 8.05.2019
// cel: zad6i7

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class DifferentWords
{
    private String tekst;

    public DifferentWords()
    {
        tekst = "default";
    }

    public void setTekst( String tekst )
    {
        this.tekst = tekst;
    }

    public void readFromFile()
    {
        try
        {
            FileReader fr = new FileReader("paper.txt");
            BufferedReader br = new BufferedReader(fr);

            String str, full = "";
            while((str = br.readLine()) != null )
            {
                full += str.toLowerCase().replace(",","").replace(".","").replace("(","").replace(")","").replace("[","").replace("]","");
                full += " ";
            }
            String[] splitFull = full.split(" ", 300000);


            Wyrazik words = new Wyrazik();
            List<Wyrazik> map = new ArrayList<Wyrazik>();

            //System.out.println(map.size());
            for( int a = 0; a < splitFull.length ; a++ )
            {
                if( splitFull[a].equals("") )
                {
                    continue;
                }

                boolean addit = true;
                if( map.size() > 0 )
                {
                    for( int b = 0; b < map.size() ; b++ )
                    {
                        if( map.get(b).isEqual(splitFull[a]) )
                        {
                            map.get(b).addNum();
                            addit = false;
                            break;
                        }
                    }
                    if( addit == true )
                    {
                        //words.setWord( splitFull[a], 0);
                        map.add( new Wyrazik(splitFull[a], 1) );
                        addit = false;
                    }
                }
                else
                {
                    words.setWord( splitFull[0], 1);
                    map.add( words );
                }
            }

            for( int a = 0 ; a < map.size(); a++ )
            {
                String tempSlowo;
                int tempIlosc;

                int zmiana = 1;
                while(zmiana > 0)
                {
                    zmiana = 0;
                    for(int i=0; i<map.size()-1; i++){
                        if( map.get(i).ilosc > map.get(i+1).ilosc)
                        {
                            tempSlowo = map.get(i+1).slowo;
                            tempIlosc = map.get(i+1).ilosc;
                            map.set( i+1, new Wyrazik(map.get(i).slowo, map.get(i).ilosc));
                            map.set( i, new Wyrazik(tempSlowo, tempIlosc));
                            zmiana++;
                        }
                    }
                }
            }

            for( int b = 0; b < map.size() ; b++ )
            {
                System.out.print(map.get(b).slowo + "=[" + map.get(b).ilosc + "]  ");
            }
            System.out.println("\n1."+map.get(map.size()-1).slowo + "=[" + map.get(map.size()-1).ilosc + "]  ");
            System.out.println("\n2."+map.get(map.size()-2).slowo + "=[" + map.get(map.size()-2).ilosc + "]  ");
            System.out.println("\n3."+map.get(map.size()-3).slowo + "=[" + map.get(map.size()-3).ilosc + "]  ");
            System.out.println( "\nRóżne wyrazy: " + map.size());

        }
        catch( IOException e )
        {
            System.out.println("File not found");
        }
    }
}
