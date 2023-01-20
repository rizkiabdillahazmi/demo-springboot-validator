package com.rizkiaazmi.repo;

import com.rizkiaazmi.entity.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
public interface MemberRepo extends CrudRepository<Member, Long> {
    boolean existsMemberByMemberNumber(String memberNumber);

    boolean existsMemberByMemberEmail(String memberEmail);
}
