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
public class Tags {

    private Integer _id = -1;
    private String tagName = "[no tag name]";
    private Integer count = -1;
    private Integer wikiPostId = -1;

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getWikiPostId() {
        return wikiPostId;
    }

    public void setWikiPostId(Integer wikiPostId) {
        this.wikiPostId = wikiPostId;
    }

    @Override
    public String toString() {
        return "Tags{" + "_id=" + _id + ", tagName=" + tagName + ", count=" + count + ", wikiPostId=" + wikiPostId + '}';
    }

}
