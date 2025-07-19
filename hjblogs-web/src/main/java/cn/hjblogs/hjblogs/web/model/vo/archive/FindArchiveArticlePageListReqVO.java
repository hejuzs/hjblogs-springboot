package cn.hjblogs.hjblogs.web.model.vo.archive;

import cn.hjblogs.hjblogs.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author JUHE
 * @version 1.0
 */
@Data
@Builder
@ApiModel(value = "文章归档分页 VO")
public class FindArchiveArticlePageListReqVO extends BasePageQuery {
}

