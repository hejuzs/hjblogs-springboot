package cn.hjblogs.hjblogs.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author JUHE
 * @version 1.0
 * @date: 2025-07-14 19:37
 * @description: 业务异常
 */
@Getter
@Setter
public class BizException extends RuntimeException {
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}