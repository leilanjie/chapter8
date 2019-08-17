package com.smart.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Date;

/**
 * Post Po类
 * 注解@Entity声明此Po类为一个实体bean，@Table注解为Board指定对应数据库表，
 * @Cache 为Board设置缓存，@Inheritance 指定Po映射关系，@DiscriminatorColumn
 * 定义了辨别符列，默认名字为DTYPE,类型为DiscriminatorType.STRING
 * @author leilanjie
 * @date 2019/8/15
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "t_post")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "post_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("1")
public class Post extends BaseDomain{
    /**
     * @Id 将postId指定为主键，@GeneratedValue 主键生成策略，@Column将各个属性映射到数据库表
     * t_post对应的字段中
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private  int postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_text")
    private String postText;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "create_time")
    private Date createTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * @ManyToOne 注解定义了多对一关系，通过@JoinColumn注解定义了多对一的关联关系
     */
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
