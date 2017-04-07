package com.example.zizi.lab3.model;

import com.orm.dsl.Table;

@Table
public class Card {
    private Long id = null;
    private String name;
    private int mana;
    private int attack;
    private int defense;
    private String comment;
    private boolean favourite;

    public Card() {
    }

    public Card(Long id, String name, int mana, int attack, int defense, String comment, boolean favourite) {
        this.id = id;
        this.name = name;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.comment = comment;
        this.favourite = favourite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
