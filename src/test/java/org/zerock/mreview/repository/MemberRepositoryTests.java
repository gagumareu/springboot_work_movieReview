package org.zerock.mreview.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.zerock.mreview.entity.Member;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMembers(){

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@email.com")
                    .pw("1234")
                    .nickname("reviewer"+i).build();
            repository.save(member);
        });
    }

    @Commit
    @Transactional
    @Test
    public void deleteByMember(){

        Long mid = 99L;

        Member member = Member.builder().mid(mid).build();

//        repository.deleteById(mid);
//        reviewRepository.deleteByMember(member);

        reviewRepository.deleteByMember(member);
        repository.deleteById(mid);

    }
}
