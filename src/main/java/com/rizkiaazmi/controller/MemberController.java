package com.rizkiaazmi.controller;

import com.rizkiaazmi.dto.MemberRequest;
import com.rizkiaazmi.dto.MemberResponse;
import com.rizkiaazmi.dto.ResponseData;
import com.rizkiaazmi.entity.Member;
import com.rizkiaazmi.repo.MemberRepo;
import com.rizkiaazmi.utility.ErrorParsingUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<ResponseData<?>> createOne(@Valid @RequestBody MemberRequest memberRequest, Errors errors){
        ResponseData<MemberResponse> response = new ResponseData<>();

        if (errors.hasErrors()){
            response.setStatus(false);
            response.setMessages(ErrorParsingUtility.parse(errors));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            Member member = modelMapper.map(memberRequest, Member.class);
            member = memberRepo.save(member);
            response.setStatus(true);
            response.getMessages().add("Member Saved!");
            response.setPayload(modelMapper.map(member, MemberResponse.class));
            return ResponseEntity.ok(response);
        } catch (Exception exception){
            response.setStatus(false);
            response.getMessages().add(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseData<List<MemberResponse>>> findAll(){
        ResponseData<List<MemberResponse>> response = new ResponseData<>();
        List<MemberResponse> listMember = new ArrayList<>();
        memberRepo.findAll().forEach(member -> {
            listMember.add(modelMapper.map(member, MemberResponse.class));
        });
        response.setStatus(true);
        response.setPayload(listMember);
        return ResponseEntity.ok(response);
    }
}
