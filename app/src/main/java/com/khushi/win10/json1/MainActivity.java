package com.khushi.win10.json1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json="{" +
                "        \"glossary\": {\n" +
                "      \"title\": \"example glossary\",\n" +
                "  \t\t\t\"GlossDiv\": {\n" +
                "        \"title\": \"S\",\n" +
                "  \t\t\t\"GlossList\": {\n" +
                "           \"GlossEntry\": {\n" +
                "                  \"ID\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "  \t\t\t\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "  \t\t\tt\t\t\t\t\t\"GlossDef\": {\n" +
                "             \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                " \t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                },\n" +
                "\t\t\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "            }" +
                "        }" +
                "   }" +
                "}" +
                "}";
        try {
            JsonDemo(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void JsonDemo(String json)throws JSONException {


            JSONObject mainObj = new JSONObject(json);
            JSONObject subObj = mainObj.getJSONObject("glossary");

            String title = subObj.getString("title");
            Log.d("tag", "title:" + title);

            JSONObject subSubObj = subObj.getJSONObject("GlossDiv");
            String subtitle = subSubObj.getString("title");
            Log.d("tag", "subtitle:" + subtitle);

            JSONObject listObj = subSubObj.getJSONObject("GlossList");
            JSONObject entryObj = listObj.getJSONObject("GlossEntry");
            String id = entryObj.getString("ID");
            Log.d("tag", "id:" + id);

            String sortAs = entryObj.getString("SortAs");
            Log.d("tag", "sortAs:" + sortAs);

            String glossTerm = entryObj.getString("GlossTerm");
            Log.d("tag", "glossTerm:" + glossTerm);

            String acronym = entryObj.getString("Acronym");
            Log.d("tag", "acronym:" + acronym);

            String abbrev = entryObj.getString("Abbrev");
            Log.d("tag", "abbrev:" + abbrev);

            JSONObject defObj = entryObj.getJSONObject("GlossDef");
            String para = defObj.getString("para");
            Log.d("tag", "para:" + para);

            JSONArray seeAlso = defObj.getJSONArray("GlossSeeAlso");
            for (int i = 0; i < seeAlso.length(); i++) {
                String temp = seeAlso.getString(i);
                Log.d("tag", "seeAlso" + temp);
            }


            String glossSeeObj = entryObj.getString("GlossSee");
            Log.d("tag", "glossSeeObj:" + glossSeeObj);

            mainObj.get("glossary");


    }
}
