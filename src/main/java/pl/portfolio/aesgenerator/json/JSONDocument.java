package pl.portfolio.aesgenerator.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;

public class JSONDocument {

    private static final Logger log = LoggerFactory.getLogger(JSONDocument.class);

    public  void getJSONFile(){
        String url = "jdbc:mysql://localhost:3306/aes";
        String username = "root";
        String password = "root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            var connection = DriverManager.getConnection(url,username,password);
            System.out.println("Działa czy nie?");
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("select * from aes");
            var jsonObject = new JSONObject();
            var jsonArray = new JSONArray();
            while(resultSet.next()){
                var record = new JSONObject();
                record.put("ID", resultSet.getInt("id"));
                record.put("TEXT", resultSet.getString("text"));
                record.put("KEY", resultSet.getString("key"));
                record.put("ENCODE_TEXT", resultSet.getString("encode_text").trim());
                jsonArray.add(record);
            }
            jsonObject.put("AES_DATA", jsonArray);
            try{
                FileWriter fileWriter = new FileWriter("output.json");
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.close();
            }catch (IOException e){
                log.error(String.valueOf(e));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            log.error(String.valueOf(e));
        }
        System.out.println("JSON file created");
    }
}
