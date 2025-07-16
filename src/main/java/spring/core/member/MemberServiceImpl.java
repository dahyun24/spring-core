package spring.core.member;

/**
 * 설계 변경으로 MemberServiceImpl은 MemoryMemberRepository를 의존하지 않는다.
 * 단지 MemberRepository 인터페이스만 의존한다.
 * MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지는 알 수 없다.
 * MemberServiceImpl의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부 AppConfig에서 결정된다.
 * MemberServiceImpl은 이제부터 "의존관계에 대한 고민은 외부"에 맡기고 "실행에만 집중"하면 된다.
 */
public class MemberServiceImpl implements MemberService {

	// memberRepository에 뭐가 들어갈지를 생성자를 통해서 전달하는 방법으로 변경
	private final MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId){
		return memberRepository.findById(memberId);
	}
}
