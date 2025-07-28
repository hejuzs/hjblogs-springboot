package cn.hjblogs.hjblogs.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author JUHE
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum ArticleTypeEnum {

    NORMAL(1, "普通"),
    WIKI(2, "收录于知识库");

    private Integer value;
    private String description;

}
