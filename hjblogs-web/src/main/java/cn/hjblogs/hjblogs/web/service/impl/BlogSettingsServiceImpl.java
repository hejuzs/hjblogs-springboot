package cn.hjblogs.hjblogs.web.service.impl;

import cn.hjblogs.hjblogs.common.domain.dos.BlogSettingsDO;
import cn.hjblogs.hjblogs.common.domain.mapper.BlogSettingsMapper;
import cn.hjblogs.hjblogs.common.utils.Response;
import cn.hjblogs.hjblogs.web.convert.BlogSettingsConvert;
import cn.hjblogs.hjblogs.web.model.vo.blogsettings.FindBlogSettingsDetailRspVO;
import cn.hjblogs.hjblogs.web.service.BlogSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JUHE
 * @version 1.0
 */
@Service
@Slf4j
public class BlogSettingsServiceImpl implements BlogSettingsService {

    @Autowired
    private BlogSettingsMapper blogSettingsMapper;

    /**
     * 获取博客设置信息
     *
     * @return
     */
    @Override
    public Response findDetail() {
        // 查询博客设置信息（约定的 ID 为 1）
        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectById(1L);
        // DO 转 VO
        FindBlogSettingsDetailRspVO vo = BlogSettingsConvert.INSTANCE.convertDO2VO(blogSettingsDO);

        return Response.success(vo);
    }
}

