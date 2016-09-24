package com.svan.veille.bsmt.meetup.domain.enums;

public enum MeetupMemberStatus {
	GOING("GOING"), NOT_GOING("NOT_GOING"), MAYBE("MAYBE");

	private String code;

	private MeetupMemberStatus(String code) {
		this.code = code;
	}

	public static final MeetupMemberStatus findByCode(String code) {
		for (MeetupMemberStatus status : MeetupMemberStatus.values()) {
			if (status.getCode().equals(code)) {
				return status;
			}
		}

		return null;
	}

	public String getCode() {
		return code;
	}

}
