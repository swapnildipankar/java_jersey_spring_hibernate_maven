package com.demoapp.demo.model.user;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import java.io.Serializable;
import java.util.Date;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(groups={PUT.class, DELETE.class}, message = "id: Missing Required Field")
    private Long id;

    @NotNull(groups=POST.class, message = "name_first: Missing Required Field")
    @JsonProperty("name_first")
    private String nameFirst;

    @JsonProperty("name_middle")
    private String nameMiddle;

    @NotNull(groups=POST.class, message = "name_last: Missing Required Field")
    @JsonProperty("name_last")
    private String nameLast;

    @NotNull(groups=POST.class)
    private String username;

    @NotNull(groups=POST.class)
    private String password;

    @JsonProperty("user_status")
    private UserStatus userStatus;

    @JsonProperty("user_status_code")
    private String userStatusCode;

    @NotNull(groups=POST.class, message = "date_of_birth: Missing Required Field")
    @JsonProperty("date_of_birth")
    private Integer dateOfBirth;

    @NotNull(groups=POST.class, message = "month_of_birth: Missing Required Field")
    @JsonProperty("month_of_birth")
    private Integer monthOfBirth;

    @NotNull(groups=POST.class, message = "year_of_birth: Missing Required Field")
    @JsonProperty("year_of_birth")
    private Integer yearOfBirth;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameMiddle() {
        return nameMiddle;
    }

    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle = nameMiddle;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        this.userStatusCode = userStatus.getStatusCode();
    }

    public String getUserStatusCode() {
        return userStatusCode;
    }

    public void setUserStatusCode(String userStatusCode) {
        this.userStatusCode = userStatusCode;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(Integer monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameMiddle='" + nameMiddle + '\'' +
                ", nameLast='" + nameLast + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userStatus=" + userStatus +
                ", userStatusCode='" + userStatusCode + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
