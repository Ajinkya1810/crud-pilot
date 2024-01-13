package CrudPilot.Executor;

import CrudPilot.Constants.DataModelConstants;
import CrudPilot.Controller.CrudController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrudExecutor {

    Logger logger = LoggerFactory.getLogger(CrudController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean createTable(Map<String, Object> request) {
        try {
            String createTableSqlQuery = "CREATE TABLE " + request.get(DataModelConstants.ELEMENT_NAME) +
                    " (id INT AUTO_INCREMENT PRIMARY KEY, ";
            createTableSqlQuery = createTableSqlQuery + createColumnFromConfiguration(request.get(DataModelConstants.CONFIGURATION)) + ")";
            jdbcTemplate.execute(createTableSqlQuery);
            logger.info("Query generated for the createTable : {}", createTableSqlQuery);
            return true;
        } catch (Exception e) {
            logger.error("Exception occurred in createTable probable cause : ", e);
            return false;
        }
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

    public String  insertDataUsingConfiguration(Object configuration) {
        LinkedHashMap<Object, Object> linkedHashMap = (LinkedHashMap<Object, Object>) configuration;
        Set<Object> keys = linkedHashMap.keySet();
        String columns = "";
        String values = "";
        for (Object key : keys) {
            columns = columns + key.toString() + ", ";
            values = values + linkedHashMap.get(key).toString() + ", ";
        }
        columns = columns.substring(0, columns.length() - 2);
        columns = columns + " ) VALUES ( ";
        values = values.substring(0, values.length() - 2);
        values = values + " )";
        return "";
    }
}
