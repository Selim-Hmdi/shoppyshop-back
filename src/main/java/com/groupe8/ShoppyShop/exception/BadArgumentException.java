package com.groupe8.ShoppyShop.exception;

public class BadArgumentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadArgumentException(String message) {
        super(message);
    }
}
