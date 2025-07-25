package ru.netology

data class Post(
    val id: Int = 1, //Идентификатор записи.
    val ownerId: Int = 54321, //Идентификатор владельца стены, на которой размещена запись.
    val fromId: Int = 12345, //Идентификатор автора записи
    val date: Int = 24, //Время публикации записи
    val text: String = "", //Текст записи.
    val comment: Comments, // Информация о комментариях к записи, объект
    val likes: Likes, // Информация о лайках к записи, объект
    val reposts: Reposts, // Информация о репостах записи, объект
    val views: Views, // Информация о просмотрах записи, Объект
    val isPinned: Boolean = false, // Информация о том, что запись закреплена.
)

data class Comments(
    val count: Int = 4_568, // количество комментов
    val canPost: Boolean = true, // может ли пользователь комментировать
    val groupsCanPost: Boolean = true, // могут ли сообщества комментировать запись
    val canClose: Boolean = false, //  может ли пользователь закрыть комментарии к записи
    val canOpen: Boolean = false, // может ли пользователь открыть комментарии к записи
)

data class Likes(
    val count: Int = 65_201, //  число пользователей, которым понравилась запись
    val userLikes: Boolean = false, //  наличие отметки «Мне нравится» от текущего пользователя
    val canLike: Boolean = true, // может ли текущий пользователь поставить отметку «Мне нравится»
    val canPublish: Boolean = true, // может ли текущий пользователь сделать репост
)

data class Reposts(
    val count: Int = 45_241, // число пользователей, скопировавших запись
    val userReposted: Boolean = false //  наличие репоста от текущего пользователя
)

data class Views(
    val count:Int = 15_000_242, // число просмотров записи
)

object WallService {
    private var nextId = 1 // уникальный ID
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post { // Метод для создания записи
        val newPost = post.copy(id = nextId++) // создаём копию поста с уникальным ID
        posts += newPost // добавляем в список
        return newPost // возвращаем обновленный пост
    }
    fun update(post: Post): Boolean {
        for ((index, existingPost) in posts.withIndex()) {
            if (existingPost.id == post.id) {
                posts[index] = post.copy() // Обновляем существующий пост новым экземпляром
                return true // Вернуть true, если обновление прошло успешно
            }
        }
        return false // Если пост с указанным id не найден, вернуть false
    }

    // Добавляем метод для получения всех постов
    fun getAllPosts(): Array<Post> {
        return posts
    }
}

fun main() {
    // Создание тестовых объектов для комментария, лайков, репостов и просмотров
//    val comments = Comments(count = 10, canPost = true)
//    val likes = Likes(count = 50, canLike = true)
//    val reposts = Reposts(count = 20, userReposted = false)
//    val views = Views(count = 100)
//
//    // Тестовая запись
//    val testPost = Post(
//        text = "Привет мир!",
//        comment = comments,
//        likes = likes,
//        reposts = reposts,
//        views = views
//    )
//
//    println("До добавления:")
//    println(WallService.getAllPosts().contentToString()) // Используем метод getAllPosts

    // Добавление записи на стену
//    val addedPost = WallService.add(testPost)
//    println("\nПосле добавления (${addedPost.id})")
//    println(WallService.getAllPosts().contentToString()) // Используем метод getAllPosts

//    // Изменённая версия записи
//    val updatedPost = addedPost.copy(text = "Изменённый текст", comment = comments, likes = likes, reposts = reposts, views = views)

//    // Попытка обновления записи
//    val resultUpdate = WallService.update(updatedPost)
//    println("\nРезультат обновления: ${if(resultUpdate) "Успешно" else "Ошибка"}")
//    println(WallService.getAllPosts().contentToString()) // Используем метод getAllPosts

//    // Повторная попытка обновления несуществующего поста
//    val nonExistentPost = Post(id = 999, text = "Несуществующая запись", comment = comments, likes = likes, reposts = reposts, views = views)
//    val resultNonExistent = WallService.update(nonExistentPost)
//    println("\nОбновление несуществующей записи: ${if(resultNonExistent) "Успешно" else "Ошибка"}")


}