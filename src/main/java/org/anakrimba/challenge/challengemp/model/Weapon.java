package org.anakrimba.challenge.challengemp.model;


import jakarta.persistence.*;

@Entity
@Table(name ="weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "weapon")
    private String weapon;

    @Column(name = "chategory")
    private String chategory;

    @Column(name = "role")
    private String role;

    public Weapon(){

    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getChategory() {
        return chategory;
    }

    public Weapon(String weapon, String chategory, String role) {
        this.weapon = weapon;
        this.chategory = chategory;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setChategory(String chategory) {
        this.chategory = chategory;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", weapon='" + weapon + '\'' +
                ", chategory='" + chategory + '\'' +
                ", role=" + role +
                '}';
    }
}
