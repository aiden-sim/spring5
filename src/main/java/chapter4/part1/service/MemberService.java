package chapter4.part1.service;

import chapter4.part1.domain.Member;

import java.util.Collection;

public interface MemberService {
	Collection<Member> findAll();

	Member find(long id);
}
