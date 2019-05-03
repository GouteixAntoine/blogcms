package gouteix.antoine.cms.tpl

import gouteix.antoine.cms.model.Article

data class IndexContext(
    val list: List<Article>
)