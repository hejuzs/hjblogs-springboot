package cn.hjblogs.hjblogs.web.service;

import cn.hjblogs.hjblogs.common.utils.Response;
import cn.hjblogs.hjblogs.web.model.vo.category.FindCategoryArticlePageListReqVO;
import cn.hjblogs.hjblogs.web.model.vo.category.FindCategoryListReqVO;

/**
 * @author JUHE
 * @version 1.0
 */
public interface CategoryService {
    /**
     * 获取分类列表
     * @return
     */
    Response findCategoryList(FindCategoryListReqVO findCategoryListReqVO);


    /**
     * 获取分类下文章分页数据
     * @param findCategoryArticlePageListReqVO
     * @return
     */
    Response findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO);
}

