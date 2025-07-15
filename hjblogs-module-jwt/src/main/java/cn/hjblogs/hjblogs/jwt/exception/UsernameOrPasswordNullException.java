package cn.hjblogs.hjblogs.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author JUHE
 * @version 1.0
 */
public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}

