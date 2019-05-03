package gouteix.antoine.cms

import gouteix.antoine.cms.model.Article

interface ArticlePresenter {

    fun start(id: Int)

    interface View {
        fun displayArticle(article: Article)
        fun displayNotFound()
    }
}