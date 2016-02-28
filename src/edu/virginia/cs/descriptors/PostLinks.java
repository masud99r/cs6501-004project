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

    private String _id;
    private String creationDate;
    private String postId;
    private String relatedPostId;
    private String PostLinkTypeId; // 1:Linked, 3:Duplicate

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getRelatedPostId() {
        return relatedPostId;
    }

    public void setRelatedPostId(String relatedPostId) {
        this.relatedPostId = relatedPostId;
    }

    public String getPostLinkTypeId() {
        return PostLinkTypeId;
    }

    public void setPostLinkTypeId(String PostLinkTypeId) {
        this.PostLinkTypeId = PostLinkTypeId;
    }

    @Override
    public String toString() {
        return "PostLinks{" + "_id=" + _id + ", creationDate=" + creationDate + ", postId=" + postId + ", relatedPostId=" + relatedPostId + ", PostLinkTypeId=" + PostLinkTypeId + '}';
    }

}
