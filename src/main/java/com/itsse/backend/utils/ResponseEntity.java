package com.itsse.backend.utils;

import org.springframework.http.HttpEntity;

public class ResponseEntity<T> extends HttpEntity<T> {
	//
	private Object status;
}
