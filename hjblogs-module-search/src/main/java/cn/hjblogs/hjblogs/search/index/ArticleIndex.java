package cn.hjblogs.hjblogs.search.index;

/**
 * @author JUHE
 * @version 1.0
 */
public interface ArticleIndex {
    /**
     * 索引名称
     */
    String NAME = "article";

    // --------------------- 文档字段 ---------------------
    String COLUMN_ID = "id";
    // 文章标题
    String COLUMN_TITLE = "title";

    // 文章封面
    String COLUMN_COVER = "cover";
    // 文章摘要
    String COLUMN_SUMMARY = "summary";

    // 文章正文内容
    String COLUMN_CONTENT = "content";
    // 文章创建时间
    String COLUMN_CREATE_TIME = "createTime";
}
