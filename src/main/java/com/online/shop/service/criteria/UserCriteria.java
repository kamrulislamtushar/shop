package com.online.shop.service.criteria;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;


public class UserCriteria implements Serializable, Criteria{

    private static final long serialVersionUID = 1L;

    private StringFilter login;
    private StringFilter email;
    public UserCriteria() {
    }

    public UserCriteria(UserCriteria other) {
        this.login = other.login == null ? null : other.login.copy();
        this.email = other.email == null ? null : other.email.copy();
    }

    @Override
    public UserCriteria copy() {
        return new UserCriteria(this);
    }


    public StringFilter getLogin() {
        return login;
    }

    public void setLogin(StringFilter login) {
        this.login = login;
    }


    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserCriteria that = (UserCriteria) o;
        return
            Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            login,
            email
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerCriteria{" +
            (login != null ? "login=" + login + ", " : "") +
            (email != null ? "email=" + email + ", " : "") +
            "}";
    }
}
