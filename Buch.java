import java.util.ArrayList;
import java.util.HashMap;
// first standard java libs then further libs
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


class Buch extends Literaturtyp
{
    public Buch(JSONObject jsonObject) {
        super(jsonObject);
    }
}
