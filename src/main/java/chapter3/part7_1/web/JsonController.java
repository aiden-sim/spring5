package chapter3.part7_1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class JsonController {
	@RequestMapping(method = RequestMethod.GET)
	public Map test() {
		Map map = new HashMap();
		map.put("username", "simjunbo");
		return map;
	}
}
