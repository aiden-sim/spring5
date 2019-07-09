package chapter4.part6.web;

import chapter4.part6.domain.Members;
import chapter4.part6.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestMemberController {
	private final MemberService memberService;

	@Autowired
	public RestMemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@RequestMapping(value = "/members", produces = MediaType.APPLICATION_XML_VALUE)
	public String getRestMembersByXml(Model model) {
		Members members = new Members();
		members.addMembers(memberService.findAll());
		model.addAttribute("members", members);
		return "xmlmembertemplate";
	}

	@RequestMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRestMembersByJson(Model model) {
		Members members = new Members();
		members.addMembers(memberService.findAll());
		model.addAttribute("members", members);
		return "jsonmembertemplate";
	}
}