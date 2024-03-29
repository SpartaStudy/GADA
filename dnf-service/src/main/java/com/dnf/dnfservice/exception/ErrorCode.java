package com.dnf.dnfservice.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	// 400 BAD_REQUEST : 잘못된 요청
	CHARACTER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 캐릭터입니다."),
	SERVER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 서버입니다."),
	SKILL_NOT_FOUND(HttpStatus.NOT_FOUND, "스킬 정보를 찾을 수 없습니다."),
	ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "아이템 정보를 찾을 수 없습니다."),
	// 404 NOT_FOUND : 리소스를 찾을 수 없음

	// Server Error 5xx
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 오류가 발생하여 요청을 수행할 수 없습니다");

	private final HttpStatus httpStatus;
	private final String message;
}
