package cn.hjblogs.hjblogs.common.domain.mapper;

import cn.hjblogs.hjblogs.common.domain.dos.ArticleDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author JUHE
 * @version 1.0
 */
public interface ArticleMapper extends BaseMapper<ArticleDO> {

    /**
     * 分页查询
     * @param current 当前页码
     * @param size 每页展示的数据量
     * @param title 文章标题
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    default Page<ArticleDO> selectPageList(Long current, Long size, String title, LocalDate startDate, LocalDate endDate) {
        // 分页对象(查询第几页、每页多少数据)
        Page<ArticleDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<ArticleDO> wrapper = Wrappers.<ArticleDO>lambdaQuery()
                .like(StringUtils.isNotBlank(title), ArticleDO::getTitle, title) // like 模块查询
                .ge(Objects.nonNull(startDate), ArticleDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), ArticleDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(ArticleDO::getCreateTime); // 按创建时间倒叙

        return selectPage(page, wrapper);
    }


    /**
     * 根据文章 ID 批量分页查询
     * @param current
     * @param size
     * @param articleIds
     * @return
     */
    default Page<ArticleDO> selectPageListByArticleIds(Long current, Long size, List<Long> articleIds) {
        // 分页对象(查询第几页、每页多少数据)
        Page<ArticleDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<ArticleDO> wrapper = Wrappers.<ArticleDO>lambdaQuery()
                .in(ArticleDO::getId, articleIds) // 批量查询
                .orderByDesc(ArticleDO::getCreateTime); // 按创建时间倒叙

        return selectPage(page, wrapper);
    }


}

