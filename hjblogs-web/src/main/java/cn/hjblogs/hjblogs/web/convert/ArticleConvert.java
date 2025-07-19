package cn.hjblogs.hjblogs.web.convert;

import cn.hjblogs.hjblogs.common.domain.dos.ArticleDO;
import cn.hjblogs.hjblogs.web.model.vo.archive.FindArchiveArticleRspVO;
import cn.hjblogs.hjblogs.web.model.vo.article.FindIndexArticlePageListRspVO;
import cn.hjblogs.hjblogs.web.model.vo.category.FindCategoryArticlePageListRspVO;
import cn.hjblogs.hjblogs.web.model.vo.tag.FindTagArticlePageListRspVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author JUHE
 * @version 1.0
 */
@Mapper
public interface ArticleConvert {
    /**
     * 初始化 convert 实例
     */
    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    FindIndexArticlePageListRspVO convertDO2VO(ArticleDO bean);


    /**
     * 将 DO 转化为归档文章 VO
     * @param bean
     * @return
     */
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    @Mapping(target = "createMonth", expression = "java(java.time.YearMonth.from(bean.getCreateTime()))")
    FindArchiveArticleRspVO convertDO2ArchiveArticleVO(ArticleDO bean);


    /**
     * 将 DO 转换成分类文章 VO
     * @param bean
     * @return
     */
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    FindCategoryArticlePageListRspVO convertDO2CategoryArticleVO(ArticleDO bean);

    /**
     * ArticleDO -> FindTagArticlePageListRspVO
     * @param bean
     * @return
     */
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    FindTagArticlePageListRspVO convertDO2TagArticleVO(ArticleDO bean);

}

