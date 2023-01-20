package com.rizkiaazmi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
@Data
@NoArgsConstructor
public class MemberResponse {
    private Long id;
    private String memberNumber;
    private String memberName;
    private String memberEmail;
}
