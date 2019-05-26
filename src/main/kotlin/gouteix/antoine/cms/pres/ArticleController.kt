
package gouteix.antoine.cms.pres

import gouteix.antoine.cms.inte.ArticlePresenter
import gouteix.antoine.cms.Model

class ArticlePresenterImpl(val model: Model, val view: ArticlePresenter.View) :
    ArticlePresenter {

    override fun start(id: Int) {
        val article = model.getArticle(id)
        if (article != null){
            view.displayArticle(article)
        } else {
            view.displayNotFound()
        }

    }
}