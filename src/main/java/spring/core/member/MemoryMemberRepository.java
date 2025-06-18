package spring.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

	// 동시성 이슈를 위해 실무에서는 ConcurrentHashMap을 사용한다.
	private static Map<Long, Member> store = new HashMap<>();

	@Override
	public void save(Member member){
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId){
		return store.get(memberId);
	}
}
