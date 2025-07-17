package cn.hjblogs.hjblogs.admin.service;

import cn.hjblogs.hjblogs.admin.model.vo.category.AddCategoryReqVO;
import cn.hjblogs.hjblogs.admin.model.vo.category.DeleteCategoryReqVO;
import cn.hjblogs.hjblogs.admin.model.vo.category.FindCategoryPageListReqVO;
import cn.hjblogs.hjblogs.common.utils.PageResponse;
import cn.hjblogs.hjblogs.common.utils.Response;

/**
 * @author JUHE
 * @version 1.0
 */
public interface AdminCategoryService {
    /**
     * 添加分类
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 分类分页数据查询
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResponse findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO);



    /**
     * 删除分类
     * @param deleteCategoryReqVO
     * @return
     */
    Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);


    /**
     * 获取文章分类的 Select 列表数据
     * @return
     */
    Response findCategorySelectList();






}

