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
public class PostHistory {

    private String _id;
    private String postHistoryTypeId; // description of the possible values given below
    //1: Initial Title - The first title a question is asked with.
    //2: Initial Body - The first raw body text a post is submitted with.
    //3: Initial Tags - The first tags a question is asked with.
    //4: Edit Title - A question's title has been changed.
    //5: Edit Body - A post's body has been changed, the raw text is stored here as markdown.
    //6: Edit Tags - A question's tags have been changed.
    //7: Rollback Title - A question's title has reverted to a previous version.
    //8: Rollback Body - A post's body has reverted to a previous version - the raw text is stored here.
    //9: Rollback Tags - A question's tags have reverted to a previous version.
    //10: Post Closed - A post was voted to be closed.
    //11: Post Reopened - A post was voted to be reopened.
    //12: Post Deleted - A post was voted to be removed.
    //13: Post Undeleted - A post was voted to be restored.
    //14: Post Locked - A post was locked by a moderator.
    //15: Post Unlocked - A post was unlocked by a moderator.
    //16: Community Owned - A post has become community owned
    //17: Post Migrated - A post was migrated
    //18: Question Merged - A question has had another , deleted question merged into itself
    //19: Question Protected - A question was protected by a moderator
    //20: Question Unprotected - A question was unprotected by a moderator
    //21: Post Disassociated - An admin removes the OwnerUserId from a post
    //22: Question Unmerged - A previously merged question has had its answers and votes restored.
    private String postId;
    private String revisionGUID;
    private String creationDate;
    private String userId;
    private String userDisplayName;
    private String comment; // this field contains the comment made by the user who edited a post
    private String text; // a raw version of the new value for a given revision
    private String closeReasonId; // 1:Exact Duplicate, 2:off-topic, 3:subjective, 4:not a real question, 7:too localized

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getPostHistoryTypeId() {
        return postHistoryTypeId;
    }

    public void setPostHistoryTypeId(String postHistoryTypeId) {
        this.postHistoryTypeId = postHistoryTypeId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getRevisionGUID() {
        return revisionGUID;
    }

    public void setRevisionGUID(String revisionGUID) {
        this.revisionGUID = revisionGUID;
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

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCloseReasonId() {
        return closeReasonId;
    }

    public void setCloseReasonId(String closeReasonId) {
        this.closeReasonId = closeReasonId;
    }

    @Override
    public String toString() {
        return "PostHistory{" + "_id=" + _id + ", postHistoryTypeId=" + postHistoryTypeId + ", postId=" + postId + ", revisionGUID=" + revisionGUID + ", creationDate=" + creationDate + ", userId=" + userId + ", userDisplayName=" + userDisplayName + ", comment=" + comment + ", text=" + text + ", closeReasonId=" + closeReasonId + '}';
    }

}
