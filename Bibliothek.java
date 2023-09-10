import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Beschreiben Sie hier die Klasse Bibliothek.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bibliothek
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String bibName;
    private static int inv = 1000;
    private HashMap<String,BibliotheksBuch> bibBuecher;
    private LinkedList<Buch> neueBuecher;
    private ArrayList<Buch> alteBuecher;
    
    public Bibliothek(String name)
    {
        bibName = name;
        bibBuecher = new HashMap<String, BibliotheksBuch>();
        neueBuecher = new LinkedList<Buch>();
        alteBuecher = new ArrayList<Buch>();
    }
    
    private static int erzeugeInventarNummer()
    {
        inv++;
        return inv;
    }
    
    private String erzeugeStandNummer(int nummer, String name)
    {
        return name + "-" + nummer;
    }
    
    public void erfasseBuch(Buch neuesBuch)
    {
        int erfasseInvnummer = erzeugeInventarNummer();
        String erfasseStandnummer = erzeugeStandNummer(erfasseInvnummer, bibName);
        BibliotheksBuch bb = new BibliotheksBuch(neuesBuch, erfasseInvnummer, erfasseStandnummer);
        bibBuecher.put(erfasseStandnummer, bb);
    }
    
    public void zeigeBibliotheksBuch(String standNummer)
    {
        if(bibBuecher.containsKey(standNummer))
        {
            BibliotheksBuch suchBuch = bibBuecher.get(standNummer);
            System.out.println(suchBuch.toString());
        }
        else
        {
            System.out.println("Standnummer unbekannt: " + standNummer);
        }
    }
    
    public double gibGesamtwert()
    {
        double gesamtwert = 0;
        ArrayList<BibliotheksBuch> bibiBuch = new ArrayList<BibliotheksBuch>(bibBuecher.values());
        for (BibliotheksBuch buchinfo : bibiBuch)
        {
            BibliotheksBuch buchInfo = buchinfo;
            double preis = buchInfo.gibBuch().gibPreis();
            gesamtwert = gesamtwert + preis;
        }
        
        return gesamtwert;
    }
    
    public void druckeBibliotheksBuecherListe()
    {
        System.out.println("\nBestand der Bibliothek: " + bibName);
        HashSet<String> hs = new HashSet<String>(bibBuecher.keySet());
        for (String buchinfo : hs)
        {
            zeigeBibliotheksBuch(buchinfo);
        }
        System.out.println("Gesamtwert: " + gibGesamtwert());
    }

    public Buch ausmustereBibliotheksBuch(String standNummer)
    {
        BibliotheksBuch bibBuch = bibBuecher.remove(standNummer);
        Buch entfernte = null;
        System.out.println();
        if(bibBuch == null)
        {
            System.out.println("Standnummer unbekannt: " + standNummer);
        }
        else
        {
            System.out.println("ausgemustert: " + standNummer );
            entfernte = bibBuch.gibBuch();
        }
        return entfernte;
    }
    
    public void kaufeBuch(Buch neuesBuch)
    {
        neueBuecher.add(neuesBuch);
    }
    
    public void druckeNeueBuecherListe()
    {
        System.out.println("\nListe der neuen Bücher");
        for (Buch neuBuch : neueBuecher)
        {
            System.out.println(neuBuch.toString());
        }
    }
    
    public void erfasseBuecher()
    {
        Iterator<Buch> bucher = neueBuecher.iterator();
        while (bucher.hasNext())
        {
            erfasseBuch(bucher.next());
        }
        neueBuecher.clear();
    }
    
    public void ausmustereBibliotheksBuchListe(String standNummer)
    {
        if(bibBuecher.containsKey(standNummer))
        {
            alteBuecher.add(ausmustereBibliotheksBuch(standNummer));
        }
        else
        {
            System.out.println("Standnummer unbekannt: " + standNummer);
        }
    }
    
    public void druckeAlteBuecherListe()
    {
        System.out.println("\nListe der alten Bücher");
        for(Buch b : alteBuecher)
        {
            System.out.println(b.toString());
        }
    }
    
    public void verschenkeBuch(String titel)
    {
        for(int i=0 ; i<alteBuecher.size() ; i++)
        {
            if(alteBuecher.get(i).gibTitel() == titel)
            {
                System.out.println("Folgendes Buch wurde verschenkt: " + alteBuecher.get(i).toString());
                alteBuecher.remove(alteBuecher.get(i));
            }
        }
    }
    
    public BibliotheksBuch liefereBibliotheksBuch(String standNummer)
    {
        return bibBuecher.get(standNummer);
    }
    
    public void transferiereBuch(String standNummer, Bibliothek bib)
    {
        BibliotheksBuch f = liefereBibliotheksBuch(standNummer);
        int d = f.gibInventnummer();
        ausmustereBibliotheksBuch(standNummer);
        BibliotheksBuch g = f;
        bib.erfasseBuch(g.gibBuch());
        String neuStandNummer =  bib.erzeugeStandNummer(d, bibName);
        System.out.println("Buch transferiert: " + standNummer);
    }
}
