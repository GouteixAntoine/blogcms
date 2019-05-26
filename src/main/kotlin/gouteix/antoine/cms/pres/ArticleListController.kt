package gouteix.antoine.cms.pres

import gouteix.antoine.cms.inte.ArticleListPresenter
import gouteix.antoine.cms.Model

class ArticleListPresenterImpl(val model: Model, val view: ArticleListPresenter.View):
    ArticleListPresenter {

    override fun start() {
        val list = model.getArticleList()
        view.displayArticleList(list)
    }
}