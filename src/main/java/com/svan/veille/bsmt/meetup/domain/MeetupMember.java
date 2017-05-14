package com.svan.veille.bsmt.meetup.domain;

import com.svan.veille.bsmt.meetup.domain.enums.MeetupMemberStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class MeetupMember {

    private String name;

    private MeetupMemberStatus status;

}
