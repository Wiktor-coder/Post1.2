package ru.netology

import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun addPost() {
        val wallService = WallService()
        val post = Post(
            ownerId = 1,
            text = "Test post",
            comment = Comments(),
            likes = Likes(),
            reposts = Reposts(),
            views = Views()
        )
        val addedPost = wallService.add(post)
        assertEquals(1, addedPost.id)
        assertEquals("Test post", addedPost.text)
    }

    @Test
    fun updateExistingPost() {
        val wallService = WallService()
        val post = Post(
            ownerId = 1,
            text = "Test post",
            comment = Comments(),
            likes = Likes(),
            reposts = Reposts(),
            views = Views()
        )
        val addedPost = wallService.add(post)
        val updatedPost = addedPost.copy(text = "Updated post")
        val result = wallService.update(updatedPost)
        assertTrue(result)
        assertEquals("Updated post", wallService.getAllPosts()[0].text)
    }

    @Test
    fun updateNonExistingPost() {
        val wallService = WallService()
        val post = Post(
            id = 100,
            ownerId = 1,
            text = "Test post",
            comment = Comments(),
            likes = Likes(),
            reposts = Reposts(),
            views = Views()
        )
        val result = wallService.update(post)
        assertFalse(result)
    }

    @Test
    fun getAllPosts() {
        val wallService = WallService()
        val post1 = Post(
            ownerId = 1,
            text = "Test post 1",
            comment = Comments(),
            likes = Likes(),
            reposts = Reposts(),
            views = Views()
        )
        val post2 = Post(
            ownerId = 2,
            text = "Test post 2",
            comment = Comments(),
            likes = Likes(),
            reposts = Reposts(),
            views = Views()
        )
        wallService.add(post1)
        wallService.add(post2)
        val posts = wallService.getAllPosts()
        assertEquals(2, posts.size)
        assertEquals("Test post 1", posts[0].text)
        assertEquals("Test post 2", posts[1].text)
    }
}