package CrudPilot.Controller;

import CrudPilot.Executor.BulkUploadExecutor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

@RestController
public class BulkUploadController {

    Logger logger = LoggerFactory.getLogger(BulkUploadController.class);

    @Autowired
    BulkUploadExecutor bulkUploadExecutor;

    @PostMapping("/bulk-upload")
    public ResponseEntity<Map<String, Object>> bulkUpload(@RequestParam("file") MultipartFile excelDataFile) throws Exception {
        logger.info("Bulk Upload called. File Name : {}", excelDataFile.getName());
        Map<String, Object> response = new HashMap<>();
        if (bulkUploadExecutor.convertExcelToSql(excelDataFile)) {
            response.put(HttpStatus.OK.toString(), "Bulk Upload Successful");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } else {
            response.put(HttpStatus.BAD_REQUEST.toString(), "Exception occurred in Bulk-Upload");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
