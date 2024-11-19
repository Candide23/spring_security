package ressouces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class TodoResource {

    @GetMapping
    public String helloWorld() {
        return "Hello World v1";
    }


}

