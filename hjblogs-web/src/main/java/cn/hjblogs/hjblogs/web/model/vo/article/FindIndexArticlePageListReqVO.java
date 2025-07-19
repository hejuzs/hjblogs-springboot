package cn.hjblogs.hjblogs.web.model.vo.article;

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
@ApiModel(value = "首页查询文章分页 VO")
public class FindIndexArticlePageListReqVO extends BasePageQuery {
}
