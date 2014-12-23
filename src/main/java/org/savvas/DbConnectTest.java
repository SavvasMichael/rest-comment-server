package org.savvas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DbConnectTest {

    private DbConnect dbConnect;

    @Before
    public void before(){
        //given
        dbConnect = new DbConnect();

    }
    @After
    public void after() throws SQLException {
        dbConnect.close();
    }

    @Test
    public void testGetComments(){
        //when
        List<Comment> comments = dbConnect.getComments();

        //then00
        Comment comment = comments.get(0);
        assertEquals("Savvas", comment.getName());
        assertEquals("Cool website guys", comment.getComment());

    }

    @Test
    public void testSaveComments(){
        //given

        String maria = "Maria" + Math.random();
        Comment commentToSave = new Comment(null, maria,"very good",null);
        //when
        dbConnect.saveComment(commentToSave);
        //then
        List<Comment> comments = dbConnect.getComments();
        Comment fetchedComment = comments.get(comments.size()-1);
        assertEquals(maria, fetchedComment.getName());


    }

}