package at.htl.tennis.control;

import at.htl.tennis.entity.Member;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InitBean {

    @Inject
    MemberRepository memberRepository;

    void init(@Observes StartupEvent event) {
        Member p = new Member("Max Mustermann", "max.mustermann@gmx.at", "06771234567", true);
        memberRepository.save(p);
    }

}
