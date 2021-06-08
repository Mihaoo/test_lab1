import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CreatJson {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        JSONArray ja = new JSONArray();
        Map m0 =new LinkedHashMap();

        Map m = new LinkedHashMap();
        m.put("Marca", "BMW");
        m.put("Model", "X6 M");

        m.put("An", "2019");
        m.put("disponibilitate", "true");
        obj.put("idMasina = 0001", m);

        JSONArray list = new JSONArray();
        list.add("Basic");
        list.add("Basic+");
        list.add("Luxury");

        m.put("completatii", list);

        Map m1 = new LinkedHashMap();

        m1.put("Marca", "Mercedes");
        m1.put("Model", "C63");
        m1.put("An", "2020");

        m1.put("disponibilitate", "true");
        obj.put("idMasina = 0002", m1);
        JSONArray list1 = new JSONArray();
        list1.add("Basic");
        list1.add("Mediu");
        list1.add("Lux");

        m1.put("completatii", list1);


        Map m2 = new LinkedHashMap();

        m2.put("Marca", "Renault");
        m2.put("Model", "Megane");
        m2.put("An", "2015");

        m2.put("disponibilitate", "true");
        obj.put("idMasina = 0003", m2);
        JSONArray list2 = new JSONArray();
        list2.add("Basic");
        list2.add("Basic Pro");
        list2.add("Basic Sport");

        m2.put("completatii", list2);




        try (FileWriter file = new FileWriter("masini.json")) {
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }
}
