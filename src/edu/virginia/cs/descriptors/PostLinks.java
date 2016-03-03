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
public class PostLinks {

    private Integer _id = -1;
    private String creationDate = "[no creation date]";
    private Integer postId = -1;
    private Integer relatedPostId = -1;
    private Integer PostLinkTypeId = -1; // 1:Linked, 3:Duplicate

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getRelatedPostId() {
        return relatedPostId;
    }

    public void setRelatedPostId(Integer relatedPostId) {
        this.relatedPostId = relatedPostId;
    }

    public Integer getPostLinkTypeId() {
        return PostLinkTypeId;
    }

    public void setPostLinkTypeId(Integer PostLinkTypeId) {
        this.PostLinkTypeId = PostLinkTypeId;
    }

    @Override
    public String toString() {
        return "PostLinks{" + "_id=" + _id + ", creationDate=" + creationDate + ", postId=" + postId + ", relatedPostId=" + relatedPostId + ", PostLinkTypeId=" + PostLinkTypeId + '}';
    }

}
