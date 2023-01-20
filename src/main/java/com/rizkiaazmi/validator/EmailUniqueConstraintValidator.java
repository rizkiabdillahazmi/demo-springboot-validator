package com.rizkiaazmi.validator;

import com.rizkiaazmi.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
public class EmailUniqueConstraintValidator implements ConstraintValidator<EmailUniqueConstraint, String> {
    @Autowired
    private MemberRepo memberRepo;
    @Override
    public boolean isValid(String memberEmail, ConstraintValidatorContext constraintValidatorContext) {
        return !memberRepo.existsMemberByMemberEmail(memberEmail);
    }
}
