<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>${rss.title} - RSS feed</title>

    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet" />
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="page-header"><h3>${rss.title} - RSS feed</h3></div>

    <div class="list-group">
    <#list rss.items as item>
        <a href="${item.link}" class="list-group-item">
            <h4 class="list-group-item-heading">${item.title}</h4>
        </a>
    </#list>
    </div>
</div>
</body>
</html>