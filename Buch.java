import java.util.ArrayList;
import java.util.HashMap;
// first standard java libs then further libs
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * Eine Klasse, deren Exemplare Informationen ber ein Buch halten.
 * Dies knnte Teil einer greren Anwendung sein, einer
 * Bibliothekssoftware beispielsweise.
 *
 * @author Carolin Altstaedt
 * @version 21.04.2024
 */
class Buch
{
    // Exemplarvariablen
    private final String bookClass;
    private final String citekey;
    private final String author;
    private final String title;
    private final String comment;
    private int anzahlAusleihvorgaenge; 
    private final int year;
    private int idx;
    
    private static int nummer = 0;

    private HashMap<Integer , Buch> buecher;


    /* Buch hierueber einlesen??
    public Buch(String filename) throws Exception
    {
        buecher = new HashMap<Integer, Buch>();
        assert (filename != null && filename.contains(".json"));
        JSONParser parser = new JSONParser();
        JSONArray booksJSON =
                (JSONArray) parser.parse(new java.io.FileReader(filename));
        for( Object obj: booksJSON){
            JSONObject jsonObject = (JSONObject) obj;
            // following code is bad, replace!
            // must delegate book details to book,why?
            // since changes are made in the book class, e.g. add year etc.
            // replace by calling constructor Buch(JSONObject obj)!
            // alter Code: buecher.add(new Buch(autor, titel));
            // better code:
            Buch b = new Buch(jsonObject);
            buecher.put(b.gibIdx(), b);
        }
    }
    */
    
    /**
     * Setze den Autor und den Titel, wenn ein Exemplar erzeugt wird.
     */
    public Buch(String buchautor, String buchtitel)
    {
        this(buchautor, buchtitel, -1);
    }
    
    /**
     * Weiterer Konstruktor, der den anderen Konstruktor aufruft und zustzlich 
     * noch das Erscheinungsjahr setzt
     */
    public Buch(String buchautor, String buchtitel, int jahr)
    {
        author = buchautor;
        title = buchtitel;
        bookClass = "unpublished";
        citekey = "Renz24";
        anzahlAusleihvorgaenge = 0;
        year = jahr;
        comment = ("Kein Kommentar");
        idx = nummer++; 
    }
    
    public Buch(JSONObject jsonObject)  {
        // geht das hier auch ohne String ???, sowas ist Scheie!!!
        bookClass = (String) jsonObject.get("class");
        citekey = (String) jsonObject.get("citekey");
        author = (String) jsonObject.get("author");
        title = (String) jsonObject.get("title");
        year = ((Long)jsonObject.get("year")).intValue();
        comment = (String) jsonObject.get("comment");
        idx = nummer++; 
    }
    
    /**
     * Methode, die den Autor zurckgibt 
     */
    public int gibIdx()
    {
        return idx;
    }
    
    /**
     * Methode, die den Autor zurckgibt 
     */
    public String gibAutor()
    {
        return author;
    }
    
    /**
     * Methode, die den Buchtitel zurckgibt 
     */
    public String gibTitel()
    {
        return title;
    }
    
    /** 
     * Methode, um ein Buch auszuleihen
     */
    public void leiheBuchAus()
    {
            anzahlAusleihvorgaenge = anzahlAusleihvorgaenge + 1; 
       
    }
    
    
    
    /**
     * Methode, um die Anzahl der Leihvorgnge auszugeben 
     */
    public int gibLeihvorgaenge()
    {
        return anzahlAusleihvorgaenge; 
    }
    
    /** 
     * Methode, um das Erscheinungsjahr auszugeben
     */
    public int gibErscheinungsjahr()
    {
        return year;
    }
    
    /** 
     * Methode, um alle Informationen, zum Buch auszugeben
     */
    public void ausgebenBuchinformationen()
    {
        System.out.println("Buchtitel: " + title);
        System.out.println("Autor: " +  author);
        System.out.println("Erscheinungsjahr: " + year );
        System.out.println("Anzahl Ausleihvorgaenge: " + anzahlAusleihvorgaenge);
        System.out.println("Kommentar:" + comment);
    }

}
