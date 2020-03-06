package cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file-view")
public class FileViewController {

	@RequestMapping("/index")
	public String index(Model model) {
		return "file-view/index";
	}
}
