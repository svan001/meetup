package com.svan.veille.bsmt.meetup.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetupMemberDto {

    private String name;

    private String status;

}
