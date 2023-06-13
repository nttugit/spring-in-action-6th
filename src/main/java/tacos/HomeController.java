package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // -> Giup Spring scan va phat hien ra (bean)
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home"; // Phai dung ten giong trong view (/static/templates/home.html)
	}
}