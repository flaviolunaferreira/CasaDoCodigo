package the.coyote.cdc.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ControllerTest {
	
	@GetMapping(value = "/api")
	public String test() {
		return "Api configurada";
	}


}
