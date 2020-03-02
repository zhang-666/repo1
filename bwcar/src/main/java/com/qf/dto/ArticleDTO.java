package com.qf.dto;

public class ArticleDTO {
    private Long id;
    private String title;
    private String source;
    private String summary;
    private String author;
    private String coverPic;
    private String tags;
    private String createTime;
    private String content;
    private Boolean allowUp;
    private Boolean allowFav;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAllowUp() {
        return allowUp;
    }

    public void setAllowUp(Boolean allowUp) {
        this.allowUp = allowUp;
    }

    public Boolean getAllowFav() {
        return allowFav;
    }

    public void setAllowFav(Boolean allowFav) {
        this.allowFav = allowFav;
    }
}
