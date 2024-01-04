package com.hyeonwoo.spring.jpa.springjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
        // 커맨드와 쿼리는 분리하는편, 그러나 Id 정도는 나중에 조회할 때 쓸 수 있으므로 Id 리턴을 하는편
        // 사이드 이펙트를 초래할 수 있기 때문
    }
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
