package com.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
public class Recuit implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long uid;
    private long pid;
    private char status;//status '1' 是被录取。

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long eid) {
        this.pid = eid;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
