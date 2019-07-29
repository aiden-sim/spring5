package chapter3.part2_1.web;

import chapter3.part2_1.domain.Member;
import chapter3.part2_1.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/member/add")
	public String addMember(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("guests", memberService.list());
		return "memberList";
	}

	@RequestMapping(value = { "/member/remove", "/member/delete" }, method = RequestMethod.GET)
	public String removeMember(@RequestParam("memberName") String memberName) {
		memberService.remove(memberName);
		// 리스트 갱신
		return "redirect:";
	}

	@RequestMapping
	public void memberList() {
	}
}
