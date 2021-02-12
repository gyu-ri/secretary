package com.nj.secretary.services.todolist.domain;

import java.util.Date;

public class Todolist {

    private int todolistId;
    private String userId;
    private String todolist;
    private Date todolistDate;
    private int finishStatus;

    public int getTodolistId() {
        return todolistId;
    }

    public void setTodolistId(int todolistId) {
        this.todolistId = todolistId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTodolist() {
        return todolist;
    }

    public void setTodolist(String todolist) {
        this.todolist = todolist;
    }

    public Date getTodolistDate() {
        return todolistDate;
    }

    public void setTodolistDate(Date todolistDate) {
        this.todolistDate = todolistDate;
    }

    public int getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(int finishStatus) {
        this.finishStatus = finishStatus;
    }


    @Override
    public String toString() {
        return "Todolist{" +
                "todolistId=" + todolistId +
                ", userId='" + userId + '\'' +
                ", todolist='" + todolist + '\'' +
                ", todolistDate=" + todolistDate +
                ", finishStatus=" + finishStatus +
                '}';
    }

}
