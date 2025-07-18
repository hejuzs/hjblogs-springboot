package cn.hjblogs.hjblogs.admin.convert;

import cn.hjblogs.hjblogs.admin.model.vo.blogsettings.FindBlogSettingsRspVO;
import cn.hjblogs.hjblogs.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import cn.hjblogs.hjblogs.common.domain.dos.BlogSettingsDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author JUHE
 * @version 1.0
 */
@Mapper
public interface BlogSettingsConvert {
    /**
     * 初始化 convert 实例
     */
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    /**
     * 将 VO 转化为 DO
     * @param bean
     * @return
     */
    BlogSettingsDO convertVO2DO(UpdateBlogSettingsReqVO bean);


    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindBlogSettingsRspVO convertDO2VO(BlogSettingsDO bean);

}

