package gouteix.antoine.cms

import gouteix.antoine.cms.model.Article

class MysqlModel(val pool: ConnectionPool) : Model {

    override fun getArticleList(): List<Article> {

        val list = ArrayList<Article>()

        pool.useConnection { connection ->
            connection.prepareStatement("SELECT id, title FROM articles").use { stmt ->
                val results = stmt.executeQuery()
                while (results.next()) {
                    list += Article(
                        results.getInt("id"),
                        results.getString("title"),
                        text = null
                    )
                }
            }
        }
        return list
    }

    override fun getArticle(id: Int): Article? {

        pool.useConnection { connection ->
            connection.prepareStatement("SELECT * FROM articles WHERE id = ?").use { stmt ->
                stmt.setInt(1, id)
                stmt.executeQuery().use { result ->
                    if (result.next()) {
                        return Article(result.getInt("id"), result.getString("title"), result.getString("text"))
                    }
                }
            }
        }
        return null
    }
}