package com.jeefw.model.frame;

import com.jeefw.model.frame.param.OlivesGroupParameter;
import com.jeefw.model.frame.param.OlivesUserParameter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;


@Entity
@Table(name = "olivesuser")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class OlivesUser extends OlivesUserParameter{

    // 各个字段的含义请查阅文档的数据库结构部分
    private static final long serialVersionUID = 6019103858711599150L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "username",length = 40, nullable = false, unique = true)
    private String userName;

    @Column(name = "userpass", length = 40, nullable = false)
    private String userPass;

    @Column(name = "useremail")
    private String  userEmail;

    @Column(name = "usertel")
    private String  userTel;

    @Column(name = "userimg")
    private String  userImg;


    @Column(name = "userintroduce")
    private String  userIntroduce;

    @Column(name = "usermemo")
    private String  userMemo;

    @Column(name = "userupport")
    private Integer  userSupport=0;

    @Column(name = "userbyattention")
    private Integer  userByAttention=0;

    @Column(name = "uesrAttention")
    private Integer  uesrAttention;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public String getUserMemo() {
        return userMemo;
    }

    public void setUserMemo(String userMemo) {
        this.userMemo = userMemo;
    }

    public Integer getUserSupport() {
        return userSupport;
    }

    public void setUserSupport(Integer userSupport) {
        this.userSupport = userSupport;
    }

    public Integer getUserByAttention() {
        return userByAttention;
    }

    public void setUserByAttention(Integer userByAttention) {
        this.userByAttention = userByAttention;
    }

    public Integer getUesrAttention() {
        return uesrAttention;
    }

    public void setUesrAttention(Integer uesrAttention) {
        this.uesrAttention = uesrAttention;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OlivesUser)) return false;

        OlivesUser that = (OlivesUser) o;

        if (!getId().equals(that.getId())) return false;
        if (!getUserName().equals(that.getUserName())) return false;
        if (!getUserPass().equals(that.getUserPass())) return false;
        if (!getUserEmail().equals(that.getUserEmail())) return false;
        if (!getUserTel().equals(that.getUserTel())) return false;
        if (!getUserImg().equals(that.getUserImg())) return false;
        if (!getUserIntroduce().equals(that.getUserIntroduce())) return false;
        if (!getUserMemo().equals(that.getUserMemo())) return false;
        if (!getUserSupport().equals(that.getUserSupport())) return false;
        if (!getUserByAttention().equals(that.getUserByAttention())) return false;
        return getUesrAttention().equals(that.getUesrAttention());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getUserPass().hashCode();
        result = 31 * result + getUserEmail().hashCode();
        result = 31 * result + getUserTel().hashCode();
        result = 31 * result + getUserImg().hashCode();
        result = 31 * result + getUserIntroduce().hashCode();
        result = 31 * result + getUserMemo().hashCode();
        result = 31 * result + getUserSupport().hashCode();
        result = 31 * result + getUserByAttention().hashCode();
        result = 31 * result + getUesrAttention().hashCode();
        return result;
    }



}
