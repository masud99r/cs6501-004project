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

    private Integer _id = -1;
    private Integer postTypeId = -1; // 1:Question, 2:Answer
    private Integer parentId = -1; // only present if postTypeId is 2
    private Integer acceptedAnswerId = -1; // only present if postTypeId is 1
    private String creationDate = "";
    private Integer score = -1;
    private Integer viewCount = -1;
    private String body = "";
    private Integer ownerUserId = -1;
    private Integer lastEditorUserId = -1;
    private String lastEditorDisplayName = "";
    private String lastEditDate = "";
    private String lastActivityDate = "";
    private String communityOwnedDate = "";
    private String closedDate = "";
    private String title = "";
    private String tags = "";
    private Integer answerCount = -1;
    private Integer commentCount = -1;
    private Integer favoriteCount = -1;

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public Integer getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(Integer postTypeId) {
        this.postTypeId = postTypeId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Integer ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Integer getLastEditorUserId() {
        return lastEditorUserId;
    }

    public void setLastEditorUserId(Integer lastEditorUserId) {
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

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    @Override
    public String toString() {
        return "Posts{" + "_id=" + _id + ", postTypeId=" + postTypeId + ", parentId=" + parentId + ", acceptedAnswerId=" + acceptedAnswerId + ", creationDate=" + creationDate + ", score=" + score + ", viewCount=" + viewCount + ", body=" + body + ", ownerUserId=" + ownerUserId + ", lastEditorUserId=" + lastEditorUserId + ", lastEditorDisplayName=" + lastEditorDisplayName + ", lastEditDate=" + lastEditDate + ", lastActivityDate=" + lastActivityDate + ", communityOwnedDate=" + communityOwnedDate + ", closedDate=" + closedDate + ", title=" + title + ", tags=" + tags + ", answerCount=" + answerCount + ", commentCount=" + commentCount + ", favoriteCount=" + favoriteCount + '}';
    }

}
