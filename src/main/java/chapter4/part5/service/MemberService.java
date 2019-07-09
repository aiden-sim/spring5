package chapter4.part5.service;

import chapter4.part5.domain.Member;

import java.util.Collection;

public interface MemberService {
	Collection<Member> findAll();

	Member find(long id);
}
