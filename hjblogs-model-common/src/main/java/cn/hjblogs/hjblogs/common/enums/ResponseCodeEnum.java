package cn.hjblogs.hjblogs.common.enums;

import cn.hjblogs.hjblogs.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author JUHE
 * @version 1.0
 * @date 2025-07-14 19:45
 * @description 响应状态码
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND("20000", "该产品不存在（测试使用）"),

    LOGIN_FAIL("20000", "登录失败"),
    USERNAME_OR_PWD_ERROR("20001", "用户名或密码错误"),
    UNAUTHORIZED("20002", "无访问权限，请先登录！"),
    FORBIDDEN("20004", "演示账号仅支持查询操作！"),



    PARAM_NOT_VALID("10001", "参数错误"),


    USERNAME_NOT_FOUND("20003", "该用户不存在"),

    // 文章分类表相关异常
    CATEGORY_NAME_IS_EXISTED("20005", "该分类已存在，请勿重复添加！"),

    TAG_NOT_EXISTED("20007", "该标签不存在！"),
    TAG_CAN_NOT_DELETE("20012", "该标签下包含文章，请先删除对应文章，才能删除！"),

    // 文件服务相关异常
    FILE_UPLOAD_FAILED("20008", "文件上传失败！"),

    // 文章相关异常
    CATEGORY_NOT_EXISTED("20009", "提交的分类不存在！"),
    ARTICLE_NOT_FOUND("20010", "该文章不存在！"),
    CATEGORY_CAN_NOT_DELETE("20011", "该分类下包含文章，请先删除对应文章，才能删除！"),


    // 知识库相关异常
    WIKI_NOT_FOUND("20013", "该知识库不存在"),



    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

}
