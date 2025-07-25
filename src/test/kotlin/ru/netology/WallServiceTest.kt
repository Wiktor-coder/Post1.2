package ru.netology

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addPost() {
        // Создание тестовых объектов
        val comments = Comments()
        val likes = Likes()
        val reposts = Reposts()
        val views = Views()

        // Тестовая запись
        val testPost = Post(
            text = "Привет мир!",
            comment = comments,
            likes = likes,
            reposts = reposts,
            views = views
        )

        // Добавление записи на стену
        val addedPost = WallService.add(testPost)

        // Проверка, что пост добавлен
        assertNotNull(addedPost)
        assertEquals(1, addedPost.id)
        assertEquals("Привет мир!", addedPost.text)
    }

//    @Test
//    fun updateExistingPost() {
//        // Создание тестовых объектов
//        val comments = Comments()
//        val likes = Likes()
//        val reposts = Reposts()
//        val views = Views()
//
//        // Добавление записи на стену
//        val testPost = Post(
//            text = "Привет мир!",
//            comment = comments,
//            likes = likes,
//            reposts = reposts,
//            views = views
//        )
//        val addedPost = WallService.add(testPost)
//
//        // Обновление записи
//        val updatedPost = addedPost.copy(text = "Обновленный текст")
//        val resultUpdate = WallService.update(updatedPost)
//
//        // Проверка, что обновление прошло успешно
//        assertTrue(resultUpdate)
//        assertEquals("Обновленный текст", WallService.getAllPosts().first().text)
//    }
//first()
    @Test
    fun updateNonExistingPost() {
        // Создание тестовых объектов
        val comments = Comments()
        val likes = Likes()
        val reposts = Reposts()
        val views = Views()

        // Несуществующая запись
        val nonExistentPost = Post(id = 999, text = "Несуществующая запись", comment = comments, likes = likes, reposts = reposts, views = views)

        // Попытка обновления несуществующего поста
        val resultUpdate = WallService.update(nonExistentPost)

        // Проверка, что обновление не прошло успешно
        assertFalse(resultUpdate)
    }

    @Test
    fun getAllPosts() {
        // Создание тестовых объектов
        val comments = Comments()
        val likes = Likes()
        val reposts = Reposts()
        val views = Views()

        // Добавление нескольких записей на стену
        //val post1 = Post(text = "Пост 1", comment = comments, likes = likes, reposts = reposts, views = views)
        val post2 = Post(text = "Пост 2", comment = comments, likes = likes, reposts = reposts, views = views)
       // WallService.add(post1)
        WallService.add(post2)

        // Получение всех постов
        val allPosts = WallService.getAllPosts()

        // Проверка, что все посты получены
        assertEquals(2, allPosts.size)
        //assertEquals("Пост 1", allPosts[0].text)
        assertEquals("Пост 2", allPosts[1].text)
    }
}