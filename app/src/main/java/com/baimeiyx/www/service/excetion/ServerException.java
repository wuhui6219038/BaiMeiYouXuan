package com.baimeiyx.www.service.excetion;

import java.io.Serializable;

/**
 * 服务器错误
 */
public class ServerException extends RuntimeException {
    public int code;
    public String message;

    public ServerException() {
        super();
    }

    public ServerException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
