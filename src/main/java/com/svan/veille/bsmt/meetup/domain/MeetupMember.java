package com.svan.veille.bsmt.meetup.domain;

import com.svan.veille.bsmt.meetup.domain.enums.MeetupMemberStatus;

public class MeetupMember {

    private String name;

    private MeetupMemberStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeetupMemberStatus getStatus() {
        return status;
    }

    public void setStatus(MeetupMemberStatus status) {
        this.status = status;
    }

}
