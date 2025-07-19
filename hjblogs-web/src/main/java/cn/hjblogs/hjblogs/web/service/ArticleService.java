package cn.hjblogs.hjblogs.web.service;

import cn.hjblogs.hjblogs.common.utils.Response;
import cn.hjblogs.hjblogs.web.model.vo.article.FindIndexArticlePageListReqVO;
import cn.hjblogs.hjblogs.web.model.vo.category.FindCategoryArticlePageListReqVO;

/**
 * @author JUHE
 * @version 1.0
 */
public interface ArticleService {
    /**
     * 获取首页文章分页数据
     * @param findIndexArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindIndexArticlePageListReqVO findIndexArticlePageListReqVO);
}

