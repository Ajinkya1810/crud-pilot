package CrudPilot.Controller;

import CrudPilot.Executor.CrudExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CrudController {

    Logger logger = LoggerFactory.getLogger(CrudController.class);

    @Autowired
    CrudExecutor crudExecutor;

    @PostMapping("/createTable")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Map<String, Object> request) {
        logger.info("Create Table called. Request received : {}", request);
        if (crudExecutor.createTable(request)) {
            return new ResponseEntity<>(request, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(request, HttpStatus.BAD_REQUEST);
        }

    }
}
