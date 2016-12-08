package com.svan.veille.bsmt.meetup.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Meetup {

    @Id
    private String id;

    private String title;

    private String description;

    private LocalDateTime date;

    private List<MeetupMember> members = new ArrayList<MeetupMember>();

    public Meetup() {
    }

    public Meetup(String title, LocalDateTime date) {
        this.title = title;
        this.date = date;
    }

    public List<MeetupMember> getMembers() {
        return members;
    }

    public void setMembers(List<MeetupMember> members) {
        this.members = members;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
