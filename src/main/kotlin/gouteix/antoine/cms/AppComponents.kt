package gouteix.antoine.cms

import gouteix.antoine.cms.inte.ArticleListPresenter
import gouteix.antoine.cms.inte.ArticlePresenter
import gouteix.antoine.cms.pres.ArticleListPresenterImpl
import gouteix.antoine.cms.pres.ArticlePresenterImpl

class AppComponents(val mySqlUrl: String, val mySqlUser: String, val mySqlPassword: String) {

    private val pool = ConnectionPool(mySqlUrl, mySqlUser, mySqlPassword)
    fun getPool(): ConnectionPool {
        return pool
    }

    private val model = MysqlModel(getPool())
    fun getModel(): Model {
        return model
    }

    fun getArticleListPresenter(view: ArticleListPresenter.View): ArticleListPresenter {
        return ArticleListPresenterImpl(getModel(), view)
    }

    fun getArticlePresenter(view: ArticlePresenter.View): ArticlePresenterImpl {
        return ArticlePresenterImpl(getModel(), view)
    }
}