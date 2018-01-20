package telefon;

import java.text.SimpleDateFormat;
import java.util.Date;

enum Stan {brak, odebrane, nieodebrane, odrzucone};
enum Rodzaj {przychodzace, wychodzace};

abstract public class Encja
{
    protected Rodzaj rodzaj;
    protected String nrTel;
    protected Date data;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("(HH:mm)");
    
    Encja(Rodzaj rodzaj, String nrTel)
    {
        this.rodzaj = rodzaj;
        this.nrTel = nrTel;
        data = new Date();
    }

    public Rodzaj getRodzaj() {
        return rodzaj;
    }

    public String getNrTel() {
        return nrTel;
    }

    public Date getData() {
        return data;
    }
}

class Polaczenie extends Encja
{
    Stan stan = Stan.brak;
    
    Polaczenie(Rodzaj rodzaj, String nrTel)
    {
        super(rodzaj, nrTel);
    }

    public Stan getStan() {
        return stan;
    }

    private void setStan(Stan stan) {
        this.stan = stan;
    }
    
    public void odbierzPolaczenie()
    {
        setStan(Stan.odebrane);
    }
    
    public void odrzucPolaczenie()
    {
        setStan(Stan.odrzucone);
    }
    
    public void zignorujPolaczenie()
    {
        setStan(Stan.nieodebrane);
    }
    
    @Override
    public String toString()
    {
        String string = dateFormat.format(data)+" "+nrTel;
        
        if(rodzaj == Rodzaj.przychodzace) string+=" przychodzace";
        if(rodzaj == Rodzaj.wychodzace) string+=" wychodzace";
        
        if(stan == Stan.nieodebrane) string+=" (nieodebrane)";
        if(stan == Stan.odebrane) string+=" (odebrane)";
        if(stan == Stan.odrzucone) string+=" (odrzucone)";
        
        return string;
    }
}

class Sms extends Encja
{
    String tresc;
    
    Sms(Rodzaj rodzaj, String nrTel, String tresc)
    {
        super(rodzaj, nrTel);
        this.tresc = tresc;
    }

    public String getTresc() {
        return tresc;
    }
    
    @Override
    public String toString()
    {
        String string = dateFormat.format(data)+" "+nrTel+" \""+tresc+"\"";
        
        if(rodzaj == Rodzaj.przychodzace) string+=" odebrany";
        if(rodzaj == Rodzaj.wychodzace) string+=" wyslany";
        
        return string;
    }
}
