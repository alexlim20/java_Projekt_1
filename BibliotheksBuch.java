
/**
 * Beschreiben Sie hier die Klasse BibliotheksBuch.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BibliotheksBuch
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Buch buch;
    private int inventNummer;
    private String standNummer;
    
    public BibliotheksBuch(Buch b, int i, String s)
    {
        buch = b;
        inventNummer = i;
        standNummer = s;
    }
    
    public Buch gibBuch()
    {
        return buch;
    }
    
    public int gibInventnummer()
    {
        return inventNummer;
    }
    
    public String gibStandnummer()
    {
        return standNummer;
    }
    
    public void setzNeustandnummer(String n)
    {
        standNummer = n;
    }
    
    public String infoBibliotheksBuch()
    {
        return "Standnummer: " + gibStandnummer() + "   Inventarnummer: " + gibInventnummer() + "   " + buch.toString();
    }
    
    public String toString()
    {
        return infoBibliotheksBuch();
    }
}
