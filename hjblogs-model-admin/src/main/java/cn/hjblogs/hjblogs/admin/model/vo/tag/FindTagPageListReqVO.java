package cn.hjblogs.hjblogs.admin.model.vo.tag;

import cn.hjblogs.hjblogs.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author JUHE
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询标签分页数据入参 VO")
public class FindTagPageListReqVO extends BasePageQuery {

    /**
     * 标签名称
     */
    private String name;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;

}
