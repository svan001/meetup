package com.svan.veille.bsmt.meetup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetupDto {

    private String id;

    private String title;

    private String description;

    private ZonedDateTime date;

    private List<MeetupMemberDto> members;

    public MeetupDto(String id, String title, ZonedDateTime date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }
}
