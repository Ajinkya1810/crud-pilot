package CrudPilot.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin based on your Angular app's URL
public class TestController {
    @GetMapping("/test")
    public String testController() {
        System.out.println("Inside TestController()");
        return "Success";
    }



}
