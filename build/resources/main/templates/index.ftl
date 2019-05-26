<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mon super Blog</title>
    <link rel="stylesheet" href="/static/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header class="topbar">
        <nav>
            <a href="/">Articles</a>
            <a href="/login">Connexion</a>
        </nav>
        <div class="social">
            <a href="https://fr-fr.facebook.com/Institut.Internet.Multimedia" title="Facebook" target="_blank"><img src="/static/img/facebook.png" alt="Facebook"></a>
            <a href="https://twitter.com/IIMparis" title="Twitter" target="_blank"><img src="/static/img/twitter.png" alt="Twitter"></a>
        </div>
    </header>
    <div class="banniere"></div>
    <main class="articles">
        <#list list as article>
            <ol>
                <a href="/article/${article.id}">${article.id} . ${article.title}</a>
            </ol>
        </#list>
    </main>
</body>
</html>