package org.cloud.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {

	private int boardId; 
	private String title; 
	private String contents; 
	private int hitCnt; 
	private Timestamp createdDatetime; 
	private String creatorId;
	private Timestamp updatedDatetime;
	private String updaterId;
	private String deletedYn;
}