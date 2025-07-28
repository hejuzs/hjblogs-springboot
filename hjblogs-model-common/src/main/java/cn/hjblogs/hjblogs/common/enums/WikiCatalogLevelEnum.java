package cn.hjblogs.hjblogs.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author JUHE
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum WikiCatalogLevelEnum {

    // 一级目录
    ONE(1),
    // 二级目录
    TWO(2);

    private Integer value;

}
