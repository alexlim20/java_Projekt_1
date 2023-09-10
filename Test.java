
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println(" *** Test der Klasse Buch ***");
        
        Buch a = new Buch ("AAA", "Autor-A", 20.45);
        Buch b = new Buch ("BBB", "Autor-B", 25.25);
        Buch c = new Buch ("CCC", "Autor-C", 11.95);
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        
        System.out.println();
        System.out.println(" *** Test der Klasse BibliotheksBuch ***");
        
        BibliotheksBuch bibul = new BibliotheksBuch(a, 123, "Buch1");
        System.out.println(bibul.infoBibliotheksBuch());
        System.out.println(bibul.toString());
        System.out.println(bibul);
        
        System.out.println();
        System.out.println(" *** Test der Klasse Bibliothek ***");
        
        Bibliothek bibKL = new Bibliothek("Bib-KL");
        
        bibKL.erfasseBuch(a);
        bibKL.erfasseBuch(b);
        bibKL.zeigeBibliotheksBuch("Bib-KL-1001");
        bibKL.zeigeBibliotheksBuch("Bib-KL-1002");
        bibKL.zeigeBibliotheksBuch("Bib-KL-1003");
        
        bibKL.druckeBibliotheksBuecherListe();
        
        Buch x = bibKL.ausmustereBibliotheksBuch("Bib-KL-1002");
        System.out.println(x.toString());
        Buch y = bibKL.ausmustereBibliotheksBuch("Bib-KL-1003");
        
        bibKL.erfasseBuch(c);
        bibKL.druckeBibliotheksBuecherListe();
        
        Buch d = new Buch("DDD","Autor-D", 33.45);
        Buch e = new Buch("EEE","Autor-E", 12.55);
        Buch f = new Buch("FFF","Autor-F", 43.35);
        
        bibKL.kaufeBuch(d);
        bibKL.kaufeBuch(e);
        bibKL.kaufeBuch(f);
        bibKL.druckeNeueBuecherListe();
        
        bibKL.erfasseBuecher();
        bibKL.druckeBibliotheksBuecherListe();
        bibKL.druckeNeueBuecherListe();
        
        bibKL.ausmustereBibliotheksBuchListe("Bib-KL-1004");
        bibKL.ausmustereBibliotheksBuchListe("Bib-KL-1003");
        bibKL.ausmustereBibliotheksBuchListe("Bib-KL-1002");
        
        bibKL.druckeBibliotheksBuecherListe();
        bibKL.druckeAlteBuecherListe();
        
        bibKL.verschenkeBuch("DDD");
        bibKL.druckeAlteBuecherListe();
        
        Bibliothek bibZW = new Bibliothek("Bib-ZW");
        bibKL.druckeBibliotheksBuecherListe();
        bibZW.druckeBibliotheksBuecherListe();
        
        bibKL.transferiereBuch("Bib-KL-1005",bibZW);
        
        bibKL.druckeBibliotheksBuecherListe();
        bibZW.druckeBibliotheksBuecherListe();
        
    }
}
