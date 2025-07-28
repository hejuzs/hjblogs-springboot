package cn.hjblogs.hjblogs.admin.service;

import cn.hjblogs.hjblogs.admin.model.vo.article.*;
import cn.hjblogs.hjblogs.common.utils.Response;

/**
 * @author JUHE
 * @version 1.0
 */
public interface AdminArticleService {
    /**
     * 发布文章
     * @param publishArticleReqVO
     * @return
     */
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);

    /**
     * 删除文章
     * @param deleteArticleReqVO
     * @return
     */
    Response deleteArticle(DeleteArticleReqVO deleteArticleReqVO);


    /**
     * 查询文章分页数据
     * @param findArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindArticlePageListReqVO findArticlePageListReqVO);

    /**
     * 查询文章详情
     * @param findArticleDetailReqVO
     * @return
     */
    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);

    /**
     * 更新文章
     * @param updateArticleReqVO
     * @return
     */
    Response updateArticle(UpdateArticleReqVO updateArticleReqVO);

    /**
     * 更新文章是否置顶
     * @param updateArticleIsTopReqVO
     * @return
     */
    Response updateArticleIsTop(UpdateArticleIsTopReqVO updateArticleIsTopReqVO);
}

