package gouteix.antoine.cms

import gouteix.antoine.cms.model.Article

interface Model {

    fun getArticleList(): List<Article>


    fun getArticle(id: Int): Article?

}