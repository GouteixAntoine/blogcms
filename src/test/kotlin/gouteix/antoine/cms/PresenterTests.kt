package gouteix.antoine.cms

import com.nhaarman.mockitokotlin2.*
import gouteix.antoine.cms.model.Article
import gouteix.antoine.cms.pres.ArticleListPresenterImpl
import gouteix.antoine.cms.pres.ArticlePresenterImpl
import junit.framework.Assert.*
import org.junit.Test
import java.util.Collections.list

internal class PresenterTests {

    @Test
    fun testArticleListPresenter() {
        val list = listOf(Article(1, "Un", null), Article(2, "Deux", null))
        val model =  mock<Model>  {
            on { getArticleList() } doReturn list
        }

        val view = mock<ArticleListPresenter.View> {
        }
        val presenter = ArticleListPresenterImpl(model, view)
        presenter.start()

        verify(model).getArticleList()
        verify(view).displayArticleList(list)
        verifyNoMoreInteractions(model, view)
    }

    @Test
    fun testArticlePresenter(){
        val id = 1
        val article = Article(id, "Un", "Lorem ipsum")
        val model = mock<Model> {
            on { getArticle(id) } doReturn article
        }

        val view = mock<ArticlePresenter.View>()

        val presenter = ArticlePresenterImpl(model, view)
        presenter.start(id)

        verify(model).getArticle(id)
        verify(view).displayArticle(article)
        verifyNoMoreInteractions(model, view)
    }

    @Test
    fun testInvalidArticlePresenter(){
        val id = 1
        val model = mock<Model> {
            on { getArticle(any()) } doReturn null
        }

        val view = mock<ArticlePresenter.View>()

        val presenter = ArticlePresenterImpl(model, view)
        presenter.start(id)

        verify(model).getArticle(id)
        verify(view).displayArticle(any())
        verifyNoMoreInteractions(model, view)
    }
}
