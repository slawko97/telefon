package telefon;

import java.util.ArrayList;
import java.util.Random;

public class Telefon
{
    ArrayList<Polaczenie> polaczenia = new ArrayList();
    ArrayList<Sms> smsy = new ArrayList();
    
    static String numeryTelefonow[] = {"5690", "5691", "5692", "5693", "5694"};
    static String tresciSms[] = {"Wszystkiego Najlepszego!", "Co u ciebie?", "Witaj!", "Hello World!", "Happy New Year!"};
    
    public Polaczenie getPolaczenie(int pozycja)
    {
        return polaczenia.get(pozycja);
    }
    
    public Sms getSms(int pozycja)
    {
        return smsy.get(pozycja);
    }
    
    public void zadzwon(String nrTel)
    {
        polaczenia.add(new Polaczenie(Rodzaj.wychodzace, nrTel));
    }
    
    public void wyslijSms(String nrTel, String tresc)
    {
        smsy.add(new Sms(Rodzaj.wychodzace, nrTel, tresc));
    }
    
    public void generujPolaczenie()
    {
        Random generator = new Random();
        
        polaczenia.add(new Polaczenie(Rodzaj.przychodzace, numeryTelefonow[generator.nextInt(5)]));
    }
    
    public void generujSms()
    {
        Random generator = new Random();
        smsy.add(new Sms(Rodzaj.przychodzace, numeryTelefonow[generator.nextInt(5)], tresciSms[generator.nextInt(5)]));
    }
    
    public void odbierzPolaczenie(int pozycja)
    {
        polaczenia.get(pozycja).odbierzPolaczenie(); 
    }
    
    public void odrzucPolaczenie(int pozycja)
    {
        polaczenia.get(pozycja).odrzucPolaczenie();
    }
    
    public String przegladajTresciSms()
    {
        String string = "";
        
        for(int i=0; i<smsy.size();i++)
        {
            string+=getSms(i).toString()+"\n";
        }
        
        return string;
    }
    
    public String przegladajHistoriePolaczen()
    {
        String string = "";
        
        for(int i=0; i<polaczenia.size();i++)
        {
            string+=getPolaczenie(i).toString()+"\n";
        }
        
        return string;
    }
    
    @Override
    public String toString()
    {
        String string = "";
        
        for (int i=0;i<polaczenia.size();i++)
        {
            string+=getPolaczenie(i).toString()+"\n";
        }
        
        for(int i=0; i<smsy.size();i++)
        {
                string+=getSms(i).toString()+"\n";
        }
        
        return string;
    }
}
