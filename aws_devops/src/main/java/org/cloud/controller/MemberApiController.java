package org.cloud.controller;

import java.util.List;

import org.cloud.dto.MemberInfoDTO;
import org.cloud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")  //vite
@RestController
@RequestMapping("/api/member")
public class MemberApiController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/list")
	public List<MemberInfoDTO> openMemberList() throws Exception {
		return memberService.memberList();
	}
	
	@PostMapping("/write")
	public String memberWrite(@RequestBody MemberInfoDTO member) throws Exception {
		memberService.writeMember(member);
		return "write success";
	}
	
	@GetMapping("/detail/{id}")
	public MemberInfoDTO memberDetail(@PathVariable("id") String id) throws Exception {
		return memberService.memberDetail(id);
	}

	@PutMapping("/update")
	public String memberUpdate(@RequestBody MemberInfoDTO member) throws Exception {
		memberService.updateMember(member);
		return "update success";
	}
	
	@DeleteMapping("/delete/{id}")
	public String memberDelete(@PathVariable("id") String id) throws Exception {
		memberService.deleteMember(id);
		return "delete success";
	}
}
