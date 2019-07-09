package chapter4.part6.service;

import chapter4.part6.domain.Member;

import java.util.Collection;

public interface MemberService {
	Collection<Member> findAll();

	Member find(long id);
}
