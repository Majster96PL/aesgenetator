package pl.portfolio.aesgenerator.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONDocument {

    public static ResultSet  RetrieveData() throws Exception{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String url = "jdbc:mysql://localhost:3306/aes";
        var connection = DriverManager.getConnection(url, "root ", "root");
        System.out.println("Connection...");
        var statement = connection.createStatement();
        return statement.executeQuery("Select * from aes");
    }

    public static void getJSON() throws Exception {
        var jsonObject = new JSONObject();
        var jsonArray = new JSONArray();
        var resultSet = RetrieveData();
        while(resultSet.next()){
            Map<String, String> jsonMap = new HashMap<>();
            jsonMap.put("ID", String.valueOf(resultSet.getInt("id")));
            jsonMap.put("Text", resultSet.getString("text"));
            jsonMap.put("Key", resultSet.getString("key"));
            jsonMap.put("Encode_Text", resultSet.getString("encode_text"));
            var recordJSONObject = new JSONObject(jsonMap);
            jsonArray.add(recordJSONObject);
        }
        jsonObject.put("AES", jsonArray);
        try{
            var fileWriter = new FileWriter("output.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("JSON file created..");
    }

}
