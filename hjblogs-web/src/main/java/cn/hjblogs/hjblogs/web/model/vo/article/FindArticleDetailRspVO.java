package cn.hjblogs.hjblogs.web.model.vo.article;

import cn.hjblogs.hjblogs.web.model.vo.tag.FindTagListRspVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author JUHE
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindArticleDetailRspVO {
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章正文（HTML）
     */
    private String content;
    /**
     * 发布时间
     */
    private LocalDateTime createTime;
    /**
     * 分类 ID
     */
    private Long categoryId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 阅读量
     */
    private Long readNum;
    /**
     * 标签集合
     */
    private List<FindTagListRspVO> tags;
    /**
     * 上一篇文章
     */
    private FindPreNextArticleRspVO preArticle;
    /**
     * 下一篇文章
     */
    private FindPreNextArticleRspVO nextArticle;

    /**
     * 总字数
     */
    private Integer totalWords;

    /**
     * 阅读时长
     */
    private String readTime;

}
