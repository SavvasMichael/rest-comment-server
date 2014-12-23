package org.savvas;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CommentController {

    @RequestMapping("/comment")
    public List<Comment> comment() throws SQLException {
        DbConnect dbConnect = new DbConnect();
        List<Comment> comments = dbConnect.getComments();
        dbConnect.close();
        return comments;
    }
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public void saveComment(@RequestBody Comment comment) throws SQLException {
        DbConnect dbConnect = new DbConnect();
        dbConnect.saveComment(comment);
        dbConnect.close();
    }
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable ("id") Long id) throws SQLException {
        DbConnect dbConnect = new DbConnect();
        dbConnect.deleteComment(id);
        dbConnect.close();
    }

}