package com.mike.teachingpractice.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "group_memberships")
public class GroupMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Group group;

    @ManyToOne
    private User student;

    // @Column(name = "joined_at", nullable = false)
    // private LocalDateTime joinedAt;

    public GroupMembership() {
    }

    public GroupMembership(Group group, User student) {
        this.group = group;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    // public LocalDateTime getJoinedAt() {
    // return joinedAt;
    // }

    // public void setJoinedAt(LocalDateTime joinedAt) {
    // this.joinedAt = joinedAt;
    // }
}
