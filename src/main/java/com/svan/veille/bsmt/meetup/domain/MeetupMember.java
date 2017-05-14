package com.svan.veille.bsmt.meetup.domain;

import com.svan.veille.bsmt.meetup.domain.enums.MeetupMemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetupMember {

    private String name;

    private MeetupMemberStatus status;

}
