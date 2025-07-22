package cn.hjblogs.hjblogs.admin.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author JUHE
 * @version 1.0
 */
@Getter
public class PublishArticleEvent extends ApplicationEvent {

    /**
     * 文章 ID
     */
    private Long articleId;

    public PublishArticleEvent(Object source, Long articleId) {
        super(source);
        this.articleId = articleId;
    }
}
