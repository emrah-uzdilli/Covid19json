package com.emrahuzdilli.covid19json.Models;

public class Bilgi {
    private Integer infected;
    private Integer tested;
    private Integer deceased;
    private Integer recovered;
    private String lastUpdatedAtApify;


    public Integer getInfected() {
        return infected;
    }

    public void setInfected(Integer infected) {
        this.infected = infected;
    }

    public Integer getTested() {
        return tested;
    }

    public void setTested(Integer tested) {
        this.tested = tested;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }


    public String getLastUpdatedAtApify() {
        return lastUpdatedAtApify;
    }

    public void setLastUpdatedAtApify(String lastUpdatedAtApify) {
        this.lastUpdatedAtApify = lastUpdatedAtApify;
    }


    @Override
    public String toString() {
        return "Bilgi{" +
                "infected=" + infected +
                ", tested=" + tested +
                ", deceased=" + deceased +
                ", recovered=" + recovered +
                ", lastUpdatedAtApify='" + lastUpdatedAtApify + '\'' +
                '}';
    }
}
