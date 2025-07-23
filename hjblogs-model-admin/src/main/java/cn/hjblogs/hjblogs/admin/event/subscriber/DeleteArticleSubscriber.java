package cn.hjblogs.hjblogs.admin.event.subscriber;

import cn.hjblogs.hjblogs.admin.event.DeleteArticleEvent;
import cn.hjblogs.hjblogs.admin.service.AdminStatisticsService;
import cn.hjblogs.hjblogs.search.LuceneHelper;
import cn.hjblogs.hjblogs.search.index.ArticleIndex;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.index.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author JUHE
 * @version 1.0
 */
@Component
@Slf4j
public class DeleteArticleSubscriber{

    @Autowired
    private LuceneHelper luceneHelper;

    @Autowired
    private AdminStatisticsService statisticsService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT) // 事务提交后触发
    @Async("threadPoolTaskExecutor")
    public void handlePublishEvent(DeleteArticleEvent event) {
        // 在这里处理收到的事件，可以是任何逻辑操作
        Long articleId = event.getArticleId();

        // 获取当前线程名称
        String threadName = Thread.currentThread().getName();

        log.info("==> threadName: {}", threadName);
        log.info("==> 文章删除事件消费成功，articleId: {}", articleId);

        // 删除条件，根据文章 id 来删除
        Term condition = new Term(ArticleIndex.COLUMN_ID, String.valueOf(articleId));

        long count = luceneHelper.deleteDocument(ArticleIndex.NAME, condition);

        log.info("==> 删除文章对应 Lucene 文档结束，articleId: {}，受影响行数: {}", articleId, count);

        // 重新统计各分类下文章总数
        statisticsService.statisticsCategoryArticleTotal();
        log.info("==> 重新统计各分类下文章总数");

        // 重新统计各标签下文章总数
        statisticsService.statisticsTagArticleTotal();
        log.info("==> 重新统计各标签下文章总数");



    }
}
