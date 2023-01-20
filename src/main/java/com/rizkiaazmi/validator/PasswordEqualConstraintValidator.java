package com.rizkiaazmi.validator;

import com.rizkiaazmi.dto.MemberRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
public class PasswordEqualConstraintValidator implements ConstraintValidator<PasswordEqualConstraint, Object> {
    @Override
    public boolean isValid(Object data, ConstraintValidatorContext constraintValidatorContext) {
        MemberRequest memberRequest = (MemberRequest) data;
        return memberRequest.getMemberPassword().equals(memberRequest.getRetypeMemberPassword());
    }
}
