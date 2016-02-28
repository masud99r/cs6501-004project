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
public class Posts {

    private String _id;
    private String postTypeId; // 1:Question, 2:Answer
    private String parentId; // only present if postTypeId is 2
    private String acceptedAnswerId; // only present if postTypeId is 1
    private String creationDate;
    private String score;
    private String viewCount;
    private String body;
    private String ownerUserId;
    private String lastEditorUserId;
    private String lastEditorDisplayName;
    private String lastEditDate;
    private String lastActivityDate;
    private String communityOwnedDate;
    private String closedDate;
    private String title;
    private String tags;
    private String answerCount;
    private String commentCount;
    private String favoriteCount;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(String postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(String acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getLastEditorUserId() {
        return lastEditorUserId;
    }

    public void setLastEditorUserId(String lastEditorUserId) {
        this.lastEditorUserId = lastEditorUserId;
    }

    public String getLastEditorDisplayName() {
        return lastEditorDisplayName;
    }

    public void setLastEditorDisplayName(String lastEditorDisplayName) {
        this.lastEditorDisplayName = lastEditorDisplayName;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setCommunityOwnedDate(String communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(String answerCount) {
        this.answerCount = answerCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    @Override
    public String toString() {
        return "Posts{" + "_id=" + _id + ", postTypeId=" + postTypeId + ", parentId=" + parentId + ", acceptedAnswerId=" + acceptedAnswerId + ", creationDate=" + creationDate + ", score=" + score + ", viewCount=" + viewCount + ", body=" + body + ", ownerUserId=" + ownerUserId + ", lastEditorUserId=" + lastEditorUserId + ", lastEditorDisplayName=" + lastEditorDisplayName + ", lastEditDate=" + lastEditDate + ", lastActivityDate=" + lastActivityDate + ", communityOwnedDate=" + communityOwnedDate + ", closedDate=" + closedDate + ", title=" + title + ", tags=" + tags + ", answerCount=" + answerCount + ", commentCount=" + commentCount + ", favoriteCount=" + favoriteCount + '}';
    }

}
