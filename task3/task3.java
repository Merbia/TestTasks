import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task3 {

    public static void main(String[] args) throws IOException, ParseException {

        // Чтение values.json
        FileReader reader1 = new FileReader(args[1]);

        JSONParser jsonParser1 = new JSONParser();
        JSONObject jsonObject1 = (JSONObject) jsonParser1.parse(reader1);

        JSONArray values = (JSONArray) jsonObject1.get("values");

        Iterator i = values.iterator();
        Map<Long, String> status1 = new HashMap<Long, String>();

        while (i.hasNext()) {
            JSONObject innerObj1 = (JSONObject) i.next();
            status1.put((Long) innerObj1.get("id"), (String) innerObj1.get("value"));
        }

//------------------------------------------------------------------------------------------------------------------

        // Чтение tests.json
        FileReader reader2 = new FileReader(args[0]);

        JSONParser jsonParser2 = new JSONParser();
        JSONObject jsonObject2 = (JSONObject) jsonParser2.parse(reader2);

        JSONArray testsArr = (JSONArray) jsonObject2.get("tests");


        for (int j = 0; j < testsArr.size(); j++ ){
            JSONObject tmp = (JSONObject) testsArr.get(j);
            myArray(status1, tmp);
        }




        try (PrintWriter out = new PrintWriter(new FileWriter("report.json"))) {
            out.write(jsonObject2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void myArray(Map<Long, String> valuesArray, JSONObject testsArray) {

        long id;
        String value;

        id = (long) testsArray.get("id");
        value = valuesArray.get(id);
        testsArray.put("value",value);
        var inners =(JSONArray) testsArray.get("values");
        if (inners != null && !inners.isEmpty()) {
            for (int i = 0; i < inners.size(); i++) {
                JSONObject inner = (JSONObject) inners.get(i);
                myArray(valuesArray, inner);
            }
        }
    }
}
