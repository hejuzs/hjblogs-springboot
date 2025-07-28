package cn.hjblogs.hjblogs.common.domain.mapper;

import cn.hjblogs.hjblogs.common.config.InsertBatchMapper;
import cn.hjblogs.hjblogs.common.domain.dos.WikiCatalogDO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * @author JUHE
 * @version 1.0
 */
public interface WikiCatalogMapper extends InsertBatchMapper<WikiCatalogDO> {

    /**
     * 拿到某个知识库下所有目录记录
     * @param wikiId
     * @return
     */
    default List<WikiCatalogDO> selectByWikiId(Long wikiId) {
        return selectList(Wrappers.<WikiCatalogDO>lambdaQuery()
                .eq(WikiCatalogDO::getWikiId, wikiId)
        );
    }

    /**
     * 删除知识库
     * @param wikiId
     * @return
     */
    default int deleteByWikiId(Long wikiId) {
        return delete(Wrappers.<WikiCatalogDO>lambdaQuery()
                .eq(WikiCatalogDO::getWikiId, wikiId));
    }

}
