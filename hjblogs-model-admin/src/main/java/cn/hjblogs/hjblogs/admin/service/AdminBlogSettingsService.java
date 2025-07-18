package cn.hjblogs.hjblogs.admin.service;

import cn.hjblogs.hjblogs.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import cn.hjblogs.hjblogs.common.utils.Response;

/**
 * @author JUHE
 * @version 1.0
 */
public interface AdminBlogSettingsService {
    /**
     * 更新博客设置信息
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);


    /**
     * 获取博客设置详情
     * @return
     */
    Response findDetail();
}

