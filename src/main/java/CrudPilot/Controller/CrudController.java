package CrudPilot.Controller;

import CrudPilot.Executor.CrudExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CrudController {

    @Autowired
    CrudExecutor crudExecutor;

    @PostMapping("/createTable")
    public String save(@RequestBody Map<String, Object> request){
        System.out.println(request);

        crudExecutor.createTable(request);

        return "save() called";
    }
}
