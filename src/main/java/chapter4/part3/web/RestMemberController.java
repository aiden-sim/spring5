package chapter4.part3.web;

import chapter4.part3.domain.Member;
import chapter4.part3.domain.Members;
import chapter4.part3.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RestMemberController {
	private final MemberService memberService;

	@Autowired
	public RestMemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@RequestMapping("/members")
	@ResponseBody
	public Members getRestMembers(Model model) {
		Members members = new Members();
		members.addMembers(memberService.findAll());
		model.addAttribute("members", members);
		return members;
	}

	@RequestMapping("/member/{memberid}")
	@ResponseBody
	public Member getMember(@PathVariable("memberid") long memberID) {
		return memberService.find(memberID);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, false));
	}

	@RequestMapping("/reservations/{date}")
	public void getReservation(@PathVariable("date") Date resDate) {
		System.out.println(resDate);
	}
}
