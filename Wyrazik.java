// autorzy Adrian Witkowski
//         Filip Bianga
// data wykonania 8.05.2019
// cel: zad6i7 - support

public class Wyrazik
{
    public String slowo;
    public int ilosc;


    public Wyrazik()
    {
        this.slowo = "";
        this.ilosc = 0;
    }

    public Wyrazik( String slowo, int ilosc )
    {
        this.slowo = slowo;
        this.ilosc = ilosc;
    }

    public void setWord( String slowo, int ilosc )
    {
        this.slowo = slowo;
        this.ilosc = ilosc;
    }

    public void addNum()
    {
        this.ilosc = ilosc + 1;
    }

    public boolean isEqual( String wyraz )
    {
        return this.slowo.equals( wyraz );
    }

    public String getWord()
    {
        return this.slowo;
    }

}
