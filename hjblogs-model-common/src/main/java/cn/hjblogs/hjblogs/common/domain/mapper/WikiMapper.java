package cn.hjblogs.hjblogs.common.domain.mapper;

import cn.hjblogs.hjblogs.common.domain.dos.WikiDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author JUHE
 * @version 1.0
 */
public interface WikiMapper extends BaseMapper<WikiDO> {

    /**
     * 分页查询
     * @param current
     * @param size
     * @param title
     * @param startDate
     * @param endDate
     * @return
     */
    default Page<WikiDO> selectPageList(Long current, Long size, String title, LocalDate startDate, LocalDate endDate, Boolean isPublish) {
        // 分页对象(查询第几页、每页多少数据)
        Page<WikiDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<WikiDO> wrapper = Wrappers.<WikiDO>lambdaQuery()
                .like(StringUtils.isNotBlank(title), WikiDO::getTitle, title) // like 模块查询
                .ge(Objects.nonNull(startDate), WikiDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), WikiDO::getCreateTime, endDate)  // 小于等于 endDate
                .eq(Objects.nonNull(isPublish), WikiDO::getIsPublish, isPublish) // 发布状态
                .orderByDesc(WikiDO::getWeight) // 按权重倒序
                .orderByDesc(WikiDO::getCreateTime); // 按创建时间倒叙

        return selectPage(page, wrapper);
    }

    /**
     * 查询最大权重
     * @return
     */
    default WikiDO selectMaxWeight() {
        return selectOne(Wrappers.<WikiDO>lambdaQuery()
                .orderByDesc(WikiDO::getWeight) // 按权重值降序排列
                .last("LIMIT 1")); // 仅查询出一条
    }

}
