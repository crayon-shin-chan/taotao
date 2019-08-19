package czy.taotao.model;

import java.util.Date;
import javax.annotation.Generated;

public class User {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.93+08:00", comments="Source field: user.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.user_name")
    private String userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.nick_name")
    private String nickName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.salt")
    private String salt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.phone")
    private String phone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.create_user")
    private Long createUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.938+08:00", comments="Source field: user.update_user")
    private Long updateUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.938+08:00", comments="Source field: user.update_time")
    private Date updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.935+08:00", comments="Source field: user.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.user_name")
    public String getUserName() {
        return userName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.user_name")
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.nick_name")
    public String getNickName() {
        return nickName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.nick_name")
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.password")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.936+08:00", comments="Source field: user.salt")
    public String getSalt() {
        return salt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.salt")
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.phone")
    public String getPhone() {
        return phone;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.phone")
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.email")
    public String getEmail() {
        return email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.email")
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.create_user")
    public Long getCreateUser() {
        return createUser;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.create_user")
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.937+08:00", comments="Source field: user.create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.938+08:00", comments="Source field: user.create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.938+08:00", comments="Source field: user.update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.938+08:00", comments="Source field: user.update_user")
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.938+08:00", comments="Source field: user.update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.938+08:00", comments="Source field: user.update_time")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}