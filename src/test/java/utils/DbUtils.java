package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {

    public static List<Map<String,String>> fetchDbData(String query){
        String dburl=ConfigReader.getPropertyValue("dbURL");
        String userName=ConfigReader.getPropertyValue("dbUserName");
        String password=ConfigReader.getPropertyValue("dbPassword");

        List<Map<String,String>> tableData=null;
        Connection connection = null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection= DriverManager.getConnection(dburl,userName,password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            ResultSetMetaData resultInfo= resultSet.getMetaData();
            tableData=new ArrayList<>();
            while (resultSet.next()){
                LinkedHashMap<String,String> rowData=new LinkedHashMap<>();
                for (int i = 1; i <= resultInfo.getColumnCount() ; i++) {
                    rowData.put(resultInfo.getColumnName(i),resultSet.getString(i));
                }
                tableData.add(rowData);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(connection!=null)
                    connection.close();
                if(statement!=null)
                    statement.close();
                if(resultSet!=null)
                    resultSet.close();



            } catch (SQLException e) {
                throw new RuntimeException("Something related to database gone wrong");
            }

        }


        return tableData;
    }
}
