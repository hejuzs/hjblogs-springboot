package cn.hjblogs.hjblogs.web.service.impl;

import cn.hjblogs.hjblogs.common.domain.dos.ArticleCategoryRelDO;
import cn.hjblogs.hjblogs.common.domain.dos.ArticleDO;
import cn.hjblogs.hjblogs.common.domain.dos.CategoryDO;
import cn.hjblogs.hjblogs.common.domain.mapper.ArticleCategoryRelMapper;
import cn.hjblogs.hjblogs.common.domain.mapper.ArticleMapper;
import cn.hjblogs.hjblogs.common.domain.mapper.CategoryMapper;
import cn.hjblogs.hjblogs.common.enums.ResponseCodeEnum;
import cn.hjblogs.hjblogs.common.exception.BizException;
import cn.hjblogs.hjblogs.common.utils.PageResponse;
import cn.hjblogs.hjblogs.common.utils.Response;
import cn.hjblogs.hjblogs.web.convert.ArticleConvert;
import cn.hjblogs.hjblogs.web.model.vo.archive.FindArchiveArticlePageListReqVO;
import cn.hjblogs.hjblogs.web.model.vo.archive.FindArchiveArticlePageListRspVO;
import cn.hjblogs.hjblogs.web.model.vo.archive.FindArchiveArticleRspVO;
import cn.hjblogs.hjblogs.web.model.vo.category.FindCategoryArticlePageListReqVO;
import cn.hjblogs.hjblogs.web.model.vo.category.FindCategoryArticlePageListRspVO;
import cn.hjblogs.hjblogs.web.service.ArchiveService;
import cn.hjblogs.hjblogs.web.service.CategoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author JUHE
 * @version 1.0
 */
@Service
@Slf4j
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 获取文章归档分页数据
     *
     * @param findArchiveArticlePageListReqVO
     * @return
     */
    @Override
    public Response findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO) {
        Long current = findArchiveArticlePageListReqVO.getCurrent();
        Long size = findArchiveArticlePageListReqVO.getSize();

        // 分页查询
        IPage<ArticleDO> page = articleMapper.selectPageList(current, size, null, null, null);
        List<ArticleDO> articleDOS = page.getRecords();

        List<FindArchiveArticlePageListRspVO> vos = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(articleDOS)) {
            // DO 转 VO
            List<FindArchiveArticleRspVO> archiveArticleRspVOS =  articleDOS.stream()
                    .map(articleDO -> ArticleConvert.INSTANCE.convertDO2ArchiveArticleVO(articleDO))
                    .collect(Collectors.toList());

            // 按创建的月份进行分组
            Map<YearMonth, List<FindArchiveArticleRspVO>> map = archiveArticleRspVOS.stream().collect(Collectors.groupingBy(FindArchiveArticleRspVO::getCreateMonth));
            // 使用 TreeMap 按月份倒序排列
            Map<YearMonth, List<FindArchiveArticleRspVO>> sortedMap = new TreeMap<>(Collections.reverseOrder());
            sortedMap.putAll(map);

            // 遍历排序后的 Map，将其转换为归档 VO
            sortedMap.forEach((k, v) -> vos.add(FindArchiveArticlePageListRspVO.builder().month(k).articles(v).build()));
        }

        return PageResponse.success(page, vos);
    }

}

