package cn.hjblogs.hjblogs.common.domain.mapper;

import cn.hjblogs.hjblogs.common.domain.dos.CategoryDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * @author JUHE
 * @version 1.0
 */
public interface CategoryMapper extends BaseMapper<CategoryDO> {

    /**
     * 根据分类名查询
     * @param categoryName
     * @return
     */
    default CategoryDO selectByName(String categoryName) {
        // 构建查询条件
        LambdaQueryWrapper<CategoryDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryDO::getName, categoryName);

        // 执行查询
        return selectOne(wrapper);
    }

    /**
     * 查询时指定数量
     * @param limit
     * @return
     */
    default List<CategoryDO> selectByLimit(Long limit) {
        return selectList(Wrappers.<CategoryDO>lambdaQuery()
                .orderByDesc(CategoryDO::getArticlesTotal) // 根据文章总数降序
                .last(String.format("LIMIT %d", limit))); // 查询指定数量
    }
}

