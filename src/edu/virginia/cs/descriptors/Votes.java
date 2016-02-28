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

    private String _id;
    private String postId;
    // 1:AcceptedByOriginator, 2:UpMod, 3:DownMod, 4:Offensive, 5:Favorite, 6:Close, 7:Reopen
    // 8:BountyStart, 9:BountyClose, 10:Deletion, 11:Undeletion, 12:Spam, 13:InformModerator
    private String voteTypeId;
    private String creationDate;
    private String userId; // only for VoteTypeId 5
    private String bountyAmount; // only for VoteTypeId 9

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getVoteTypeId() {
        return voteTypeId;
    }

    public void setVoteTypeId(String voteTypeId) {
        this.voteTypeId = voteTypeId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
