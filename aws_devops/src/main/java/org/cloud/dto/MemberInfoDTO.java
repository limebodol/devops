package org.cloud.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MemberInfoDTO {

	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String mail;
	private String phone;
	private String address;
	private String registDay;
	
}
