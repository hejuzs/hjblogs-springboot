package cn.hjblogs.hjblogs.common.domain.mapper;

import cn.hjblogs.hjblogs.common.domain.dos.CategoryDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}

