package com.raphadrummond.myapplication;

public class User {
    private String name, pos, pais, vencidas, disputadas, avatarUrl,maximo2, pla2, maximo1, pla1;
    private int percentual, pos1,pos2;

    public User(String name, int percentual, String pos, String pais, String vencidas, String maximo1, String pla1, int pos1, String disputadas, String maximo2, String pla2, int pos2, String avatarUrl) {
        this.name = name;
        this.percentual = percentual;
        this.pos = pos;
        this.pais = pais;
        this.vencidas = vencidas;
        this.maximo1 = maximo1;
        this.pla1 = pla1;
        this.pos1 = pos1;
        this.disputadas = disputadas;
        this.maximo2 = maximo2;
        this.pla2 = pla2;
        this.pos2 = pos2;
        this.avatarUrl =avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getPos() {
        return pos;
    }

    public String getPais() {
        return pais;
    }

    public String getVencidas() {
        return vencidas;
    }

    public String getDisputadas() {
        return disputadas;
    }

    public int getPercentual() {
        return percentual;
    }

    public String getMaximo1() {
        return maximo1;
    }

    public String getPla1() {
        return pla1;
    }

    public int getPos1() {
        return pos1;
    }

    public String getMaximo2() {
        return maximo2;
    }

    public String getPla2() {
        return pla2;
    }

    public int getPos2() {
        return pos2;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
