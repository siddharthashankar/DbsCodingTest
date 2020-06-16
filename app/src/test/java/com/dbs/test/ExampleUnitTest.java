package com.dbs.test;

import android.content.Context;

import com.dbs.test.model.Article;
import com.dbs.test.view.adapter.ArticleAdapter;

import org.junit.Test;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Integer id;
    private String title;
    private Integer last_update;
    private String short_description;
    private String avatar;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void articleTest(){
        Article article = new Article(1, "article 1 title", 1586404611, "This is article 1 short description. She wholly fat who window extent either formal. Removing welcomed civility or hastened is.", "https://minotar.net/avatar/user2");
        assertEquals("article 1 title",article.getTitle());
        assertEquals("1",article.getId().toString());
        assertEquals("1586404611",article.getLast_update().toString());
        assertEquals("https://minotar.net/avatar/user2",article.getAvatar().toString());
    }


}