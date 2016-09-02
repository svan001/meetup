package com.svan.veille.bsmt.meetup.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MeetupDto {

	private String id;

	private String title;

	private LocalDateTime date;

	private List<MeetupMemberDto> members;

	public MeetupDto() {
	}

	public MeetupDto(String title, LocalDateTime date) {
		this.title = title;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public List<MeetupMemberDto> getMembers() {
		return members;
	}

	public void setMembers(List<MeetupMemberDto> members) {
		this.members = members;
	}

}
