package cn.hjblogs.hjblogs.admin.convert;

import cn.hjblogs.hjblogs.admin.model.vo.article.FindArticleDetailRspVO;
import cn.hjblogs.hjblogs.common.domain.dos.ArticleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author JUHE
 * @version 1.0
 */
@Mapper
public interface ArticleDetailConvert {
    /**
     * 初始化 convert 实例
     */
    ArticleDetailConvert INSTANCE = Mappers.getMapper(ArticleDetailConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindArticleDetailRspVO convertDO2VO(ArticleDO bean);

}

