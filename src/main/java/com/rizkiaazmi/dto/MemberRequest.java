package com.rizkiaazmi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
@Data
@NoArgsConstructor
public class MemberRequest {
    private String memberNumber;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String retypeMemberPassword;
}
