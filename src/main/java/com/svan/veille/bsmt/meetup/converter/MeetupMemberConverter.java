package com.svan.veille.bsmt.meetup.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.svan.veille.bsmt.meetup.domain.MeetupMember;
import com.svan.veille.bsmt.meetup.domain.enums.MeetupMemberStatus;
import com.svan.veille.bsmt.meetup.dto.MeetupMemberDto;

@Component
public class MeetupMemberConverter {

    public MeetupMember toDomain(MeetupMemberDto src) {
        MeetupMember dest = new MeetupMember();

        dest.setName(src.getName());
        dest.setStatus(MeetupMemberStatus.findByCode(src.getStatus()));

        return dest;
    }

    public MeetupMemberDto toDTO(MeetupMember src) {
        MeetupMemberDto dest = new MeetupMemberDto();

        dest.setName(src.getName());
        dest.setStatus(src.getStatus().getCode());

        return dest;
    }

    public List<MeetupMemberDto> toDTO(List<MeetupMember> src) {
        return src != null ? src.stream().map(r -> toDTO(r)).collect(Collectors.toList()) : null;
    }

    public List<MeetupMember> toDomain(List<MeetupMemberDto> src) {
        return src != null ? src.stream().map(r -> toDomain(r)).collect(Collectors.toList()) : null;
    }

}
