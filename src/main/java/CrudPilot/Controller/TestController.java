package CrudPilot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class TestController {
    @GetMapping("/test")
    public String testController() {
        System.out.println("Inside TestController()");
        return "Success";
    }



}
