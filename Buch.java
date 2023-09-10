
/**
 * Beschreiben Sie hier die Klasse Buch.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Buch
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String titel;
    private String autor;
    private double preis;
    
    public Buch(String t, String a, double p)
    {
        titel = t;
        autor = a;
        preis = p;
    }

    public String gibTitel()
    {
        return titel;
    }
    
    public String gibAutor()
    {
        return autor;
    }
    
    public double gibPreis()
    {
        return preis;
    }
    
    public String toString()
    {
        return "Titel: " + gibTitel() + "   Autor: " + gibAutor() + "   Preis: " + gibPreis();
    }
}
