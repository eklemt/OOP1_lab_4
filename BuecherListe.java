import java.util.ArrayList;
// first standard java libs then further libs
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.HashMap; 

/**
 * Eine Klasse, deren Instanzen Informationen ber ein BuecherListe halten.
 * Dies knnte Teil einer greren Anwendung sein, einer
 * Bibliothekssoftware beispielsweise.
 *
 * @author Wolfgang Renz
 * @version April 2024
 */
class BuecherListe
{
    // konstante Klassenvariable, die unabhngig von Instanzen existiert
    private static final String DefaultFILE = "resources/Unveroeffentlicht.json";

    // Instanzvariablen
    private HashMap<Integer , Buch> buecher;


    /**
     * default constructor
     * 
     */
    public BuecherListe() throws Exception
    {
        this(DefaultFILE);
    }

    /**
     * constructor by reading booklist from JSON file.
     * @param filename Name der Datei mit der Endung .json
    */
    public BuecherListe(String filename) throws Exception
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

    // weitere Methoden hier einfgen ...

    public void fuegeBuchHinzu(Buch buch)
    {
        buecher.put(buecher.size()+1, buch);
    }

    public void ausgeben()
    {
        System.out.println("Buecherliste:");
        for(int idx: buecher.keySet()){
            System.out.println("Index:" +idx); 
            buecher.get(idx).ausgebenBuchinformationen();
        }
    }
    public static void main(String[] args) throws Exception {
        BuecherListe buecherL1 = new BuecherListe();
        buecherL1.ausgeben();
    }
}
