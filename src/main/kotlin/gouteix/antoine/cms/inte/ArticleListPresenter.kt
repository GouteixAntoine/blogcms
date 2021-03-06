package gouteix.antoine.cms.inte

import gouteix.antoine.cms.model.Article

interface ArticleListPresenter {

    fun start()

    interface View {
        fun displayArticleList(list: List<Article>)
    }
}