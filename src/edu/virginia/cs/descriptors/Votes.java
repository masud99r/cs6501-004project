/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.virginia.cs.descriptors;

/**
 *
 * @author Wasi
 */
public class Votes {

    private Integer _id = -1;
    private Integer postId = -1;
    // 1:AcceptedByOriginator, 2:UpMod, 3:DownMod, 4:Offensive, 5:Favorite, 6:Close, 7:Reopen
    // 8:BountyStart, 9:BountyClose, 10:Deletion, 11:Undeletion, 12:Spam, 13:InformModerator
    private Integer voteTypeId = -1;
    private String creationDate = "";
    private Integer userId = -1; // only for VoteTypeId 5
    private String bountyAmount = ""; // only for VoteTypeId 9

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getVoteTypeId() {
        return voteTypeId;
    }

    public void setVoteTypeId(Integer voteTypeId) {
        this.voteTypeId = voteTypeId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBountyAmount() {
        return bountyAmount;
    }

    public void setBountyAmount(String bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    @Override
    public String toString() {
        return "Votes{" + "_id=" + _id + ", postId=" + postId + ", voteTypeId=" + voteTypeId + ", creationDate=" + creationDate + ", userId=" + userId + ", bountyAmount=" + bountyAmount + '}';
    }

}
