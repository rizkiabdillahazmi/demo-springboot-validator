package com.rizkiaazmi.dto;

import com.rizkiaazmi.validator.NumberUniqueConstraint;
import com.rizkiaazmi.validator.PasswordEqualConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
@Data
@NoArgsConstructor
@PasswordEqualConstraint(message = "Retype password invalid!")
public class MemberRequest {
    @NotEmpty(message = "Number is required")
    @Size(min = 3, max = 5, message = "Number length must be in 3 to 5 characters")
    @Pattern(regexp = "MB[0-9]+", message = "Number must be start with \'MB\'")
    @NumberUniqueConstraint(message = "Number Member already in use")
    private String memberNumber;
    @NotEmpty(message = "Name is required")
    private String memberName;
    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email address")
    private String memberEmail;
    @NotEmpty(message = "Password is required")
    private String memberPassword;
    @NotEmpty(message = "Retype Password is required")
    private String retypeMemberPassword;
}
