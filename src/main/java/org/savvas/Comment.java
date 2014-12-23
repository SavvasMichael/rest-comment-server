package org.savvas;

import java.sql.Timestamp;

public class Comment {

    private Long id;
    private String name;
    private String comment;
    private Timestamp createDate;

    public Comment(){};

    public Comment(Long id,String name, String comment, Timestamp createDate){
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.createDate = createDate;
            
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getComment(){
        return comment;
    }
    public Timestamp getCreateDate(){
        return createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
