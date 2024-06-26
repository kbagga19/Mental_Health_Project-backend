package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document("users")
public class User implements UserDetails {
    private String _id;
    private String name;
    private Long number;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String gender;
    private String income;
    private String age;
    private EmergencyContact emergencyContact;
    private String subscription;
    private boolean enabled = true;

    public User() {

    }

    public User(String _id, String name, Long number, String email, String password, String gender, String income, String age, EmergencyContact emergencyContact, String subscription, boolean enabled) {
        this._id = _id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.income = income;
        this.age = age;
        this.emergencyContact = emergencyContact;
        this.subscription = subscription;
        this.enabled = enabled;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return email;
    }

    public String get_id() { return _id; }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Long getNumber() { return number; }

    public void setNumber(Long number) { this.number = number; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
