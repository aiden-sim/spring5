package chapter3.part2_1.service;

import chapter3.part2_1.domain.Member;

import java.util.List;

public interface MemberService {
	void add(Member member);

	void remove(String memberName);

	List<Member> list();
}
