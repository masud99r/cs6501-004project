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
public class Users {

    private Integer userId;
    private Integer reputation = -1;
    private String creationDate = "";
    private String displayName = "";
    private String emailHash = "";
    private String lastAccessDate = "";
    private String websiteUrl = "";
    private String location = "";
    private Integer age = -1;
    private String aboutMe = "";
    private Integer views = -1;
    private Integer upVotes = -1;
    private Integer downVotes = -1;
    private Integer accountId = -1;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailHash() {
        return emailHash;
    }

    public void setEmailHash(String emailHash) {
        this.emailHash = emailHash;
    }

    public String getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(String lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
        this.downVotes = downVotes;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String[] getAttributes() {
        return new String[]{"Id", "Reputation", "CreationDate", "DisplayName", "EmailHash", "LastAccessDate", "WebsiteUrl", "Location", "Age",
            "AboutMe", "Views", "UpVotes", "DownVotes", "AccountId"};
    }

    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", reputation=" + reputation + ", creationDate=" + creationDate + ", displayName=" + displayName + ", emailHash=" + emailHash + ", lastAccessDate=" + lastAccessDate + ", websiteUrl=" + websiteUrl + ", location=" + location + ", age=" + age + ", aboutMe=" + aboutMe + ", views=" + views + ", upVotes=" + upVotes + ", downVotes=" + downVotes + ", accountId=" + accountId + '}';
    }

}
