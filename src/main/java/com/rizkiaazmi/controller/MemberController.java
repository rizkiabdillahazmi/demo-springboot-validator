package com.rizkiaazmi.controller;

import com.rizkiaazmi.dto.MemberRequest;
import com.rizkiaazmi.dto.MemberResponse;
import com.rizkiaazmi.dto.ResponseData;
import com.rizkiaazmi.entity.Member;
import com.rizkiaazmi.repo.MemberRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseData<?>> createOne(@RequestBody MemberRequest memberRequest){
        ResponseData<MemberResponse> response = new ResponseData<>();
        Member member = modelMapper.map(memberRequest, Member.class);
        member = memberRepo.save(member);
        response.setStatus(true);
        response.getMessages().add("Member Saved!");
        response.setPayload(modelMapper.map(member, MemberResponse.class));
        return ResponseEntity.ok(response);
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
