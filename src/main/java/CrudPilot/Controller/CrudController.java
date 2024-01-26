package CrudPilot.Controller;

import CrudPilot.Executor.CrudExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
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
            Map<String, Object> response = new HashMap<>();
            response.put(HttpStatus.BAD_REQUEST.toString(), "Exception occurred while Creating table");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
    
	@PostMapping("/insertData")
	public ResponseEntity<Map<String, Object>> insertData(@RequestBody Map<String, Object> request) {
		logger.info("Insert Table called. Request received : {}", request);

		if (crudExecutor.insertData(request)) {
			return new ResponseEntity<>(request, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(request, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/showData")
	public ResponseEntity<List<Map<String, Object>>> ShowData(@RequestBody Map<String, Object> request) {
		logger.info("Show Table called. Request received : {}", request);

		return new ResponseEntity<>(crudExecutor.showData(request), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/upload")
    public String handleFileUpload(@RequestParam("data") String data) {
        try {
           
            String filePath = "D:\\github repo neyo\\crud-pilot\\data\\file.txt";

            writeStringToFile(data, filePath);            
            //write a 
            return "redirect || success";
        } catch (IOException e) {
            
            e.printStackTrace();
            return "redirect || error";
        }
    }
	
	private void writeStringToFile(String data, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, data.getBytes());
    }
}
