package com.kawamura.todo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Controller
class HtmlController(private val repository: ArticleRepository, private val blogUserRepository: BlogUserRepository) {

    @GetMapping("/blog")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        val bloguser_1 = BlogUser("user1", "kentaro", "kawamura")
        blogUserRepository.save(bloguser_1)
        val article_1 = Article("firstarticle", bloguser_1)
        repository.save(article_1)
        val article_2 = Article("secondarticle", bloguser_1)
        repository.save(article_2)
        println("testtest")
        println(article_1.addedAt.format())
        println("test")
        model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        model["blogusers"] = blogUserRepository.findByFirstName("kentaro")
        val bloguserTmp = blogUserRepository.findByFirstName("kentaro")
        val articlesTmp = repository.findAllByOrderByAddedAtDesc()

        println("blogUserRepository: $bloguserTmp")
        println("articlesTmp: $articlesTmp")
//        model["articles"] = article_1
        return "blog"
    }

    @GetMapping("/blog/{id}")
    fun article(@PathVariable id: Long, model: Model): String{
        println("id: $id")
        val article = repository.findById(id)
        if(article.isPresent) {
            println("present id: $id")
            val renderArticle = article.get().render()
            model["article"] = renderArticle
            model["title"] = renderArticle.title
            model["author"] = renderArticle.author
            model["firstName"] = renderArticle.author.firstName
        }
        else {
            println("not found article at id: $id")
        }
        return "article"
    }
}

data class RenderArticle(
    val title: String,
    val author: BlogUser,
    val addedAt: String
)

fun Article.render() = RenderArticle(title, author, addedAt.format())

