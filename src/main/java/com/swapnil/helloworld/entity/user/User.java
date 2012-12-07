package com.swapnil.helloworld.entity.user;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.codehaus.jackson.annotate.JsonProperty;

public class User {
    @NotNull(groups={PUT.class, GET.class, DELETE.class})
    private String id;

    @NotNull(groups=POST.class)
    @JsonProperty("name_first")
    private String nameFirst;

    @JsonProperty("name_middle")
    private String nameMiddle;

    @NotNull(groups=POST.class)
    @JsonProperty("name_last")
    private String nameLast;

    @NotNull(groups=POST.class)
    private String username;

    @NotNull(groups=POST.class)
    private String password;

    @JsonProperty("date_of_birth")
    @NotNull(groups=POST.class)
    private Integer dateOfBirth;

    @NotNull(groups=POST.class)
    @JsonProperty("month_of_birth")
    private Integer monthOfBirth;

    @NotNull(groups=POST.class)
    @JsonProperty("year_of_birth")
    private Integer yearOfBirth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
