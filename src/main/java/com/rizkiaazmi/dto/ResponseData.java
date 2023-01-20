package com.rizkiaazmi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
@Data
@NoArgsConstructor
public class ResponseData<T> {
    private boolean status;
    private List<String> messages = new ArrayList<>();
    private T payload;
}
