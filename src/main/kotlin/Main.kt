package ru.netology

abstract class Attachment {
    abstract val type: String
}

data class PhotoAttachment(
    val photo: Photo
): Attachment() {
    override val type = "Photo"
}

data class VideoAttachment(
    val video: Video
) : Attachment() {
    override val type = "video"
}

data class AudioAttachment(
    val audio: Audio
) : Attachment() {
    override val type = "audio"
}

data class LinkAttachment(
    val link: Link
): Attachment() {
    override val type = "link"
}

data class DocAttachment(
    val doc: Doc
): Attachment() {
    override val type = "Doc"
}

data class Photo(
    val id: Int,
    val ownerId: Int,
    val photo130: Int,
    val photo604: Int,
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int,
)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
)

data class Link(
    val url: String,
    val title: String,
    val description: String,
    val imageSrc: String,
)

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
)


data class Post(
    val id: Int = 1, //Идентификатор записи.
    val ownerId: Int = 54321, //Идентификатор владельца стены, на которой размещена запись.
    val fromId: Int? = null, //Идентификатор автора записи
    val date: Int = 24, //Время публикации записи
    val text: String? = null, //Текст записи.
    val comment: Comments, // Информация о комментариях к записи, объект
    val likes: Likes, // Информация о лайках к записи, объект
    val reposts: Reposts, // Информация о репостах записи, объект
    val views: Views, // Информация о просмотрах записи, Объект
    val isPinned: Boolean = false, // Информация о том, что запись закреплена.
    val attachments: List<Attachment> = emptyList() //список вложений
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

class WallService {
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

}