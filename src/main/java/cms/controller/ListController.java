package cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListController {

	@RequestMapping("/index")
	public String index(Model model) {
		return "list/index";
	}
}
