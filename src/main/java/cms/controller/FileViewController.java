package cms.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file-view")
public class FileViewController {

	@RequestMapping("/index")
	public String index(Model model) {
		File rootFile = new File("");
		
		for(String f : rootFile.list()) {
			System.out.println(f);
		}
		
		model.addAttribute("fileList", rootFile.list());

		return "file-view/index";
	}
}
