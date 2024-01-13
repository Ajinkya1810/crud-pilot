package CrudPilot.Executor;

import CrudPilot.Constants.DataModelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrudExecutor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String createTable(Map<String, Object> request){

        String createTableSqlQuery = "CREATE TABLE " + request.get(DataModelConstants.ELEMENT_NAME) +
                " (id INT AUTO_INCREMENT PRIMARY KEY, ";

        createTableSqlQuery = createTableSqlQuery + createColumnFromConfiguration(request.get(DataModelConstants.CONFIGURATION)) + ")";

        jdbcTemplate.execute(createTableSqlQuery);

        return "CrudExecutor save() called";
    }

    public String createColumnFromConfiguration(Object configuration) {

        String createColumnQuery = "";
        LinkedHashMap<Object, Object> linkedHashMap = (LinkedHashMap<Object, Object>) configuration;
        Set<Object> keys = linkedHashMap.keySet();

        for (Object key : keys) {
            createColumnQuery = createColumnQuery + " " + key.toString() + " " + linkedHashMap.get(key).toString() + ", ";
        }
        return createColumnQuery.substring(0, createColumnQuery.length() - 2);
    }

}
