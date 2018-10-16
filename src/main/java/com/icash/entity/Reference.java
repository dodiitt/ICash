package com.icash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reference")
public class Reference {

    @Id
    private String id;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "friend_id")
    private String friendID;

    @Column(name = "total_icons_of_friend")
    private Integer totalICoinsOfFriend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFriendID() {
        return friendID;
    }

    public void setFriendID(String friendID) {
        this.friendID = friendID;
    }

    public Integer getTotalICoinsOfFriend() {
        return totalICoinsOfFriend;
    }

    public void setTotalICoinsOfFriend(Integer totalICoinsOfFriend) {
        this.totalICoinsOfFriend = totalICoinsOfFriend;
    }
}
