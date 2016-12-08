package com.svan.veille.bsmt.meetup.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class MeetupDto {

    private String id;

    private String title;

    private String description;

    private ZonedDateTime date;

    private List<MeetupMemberDto> members;

    public MeetupDto() {
    }

    public MeetupDto(String id, String title, ZonedDateTime date) {
        this.id = id;
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

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public List<MeetupMemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<MeetupMemberDto> members) {
        this.members = members;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
