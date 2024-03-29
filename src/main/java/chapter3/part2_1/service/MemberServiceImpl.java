package chapter3.part2_1.service;

import chapter3.part2_1.domain.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class MemberServiceImpl implements MemberService {
	private Map<String, Member> members = new TreeMap<>();

	@Override public void add(Member member) {
		members.put(member.getName(), member);
	}

	@Override public void remove(String memberName) {
		members.remove(memberName);
	}

	@Override public List<Member> list() {
		return new ArrayList<>(members.values());
	}
}
