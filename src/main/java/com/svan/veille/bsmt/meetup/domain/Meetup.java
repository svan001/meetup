package com.svan.veille.bsmt.meetup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meetup {

    @Id
    private String id;

    private String title;

    private String description;

    private LocalDateTime date;

    private List<MeetupMember> members = new ArrayList<MeetupMember>();

    public Meetup(String title, LocalDateTime date) {
        this.title = title;
        this.date = date;
    }
}
