package chapter4.part5.web;

import chapter4.part5.domain.Members;
import chapter4.part5.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/members")
	public String getRestMembers(Model model) {
		Members members = new Members();
		members.addMembers(memberService.findAll());
		model.addAttribute("members", members);
		return "jsonmembertemplate";
	}
}
