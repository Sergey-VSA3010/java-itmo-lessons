package com.company.project.lesson11;

public class Article {
    private Country country;// null изначально
    private Planets planets;

    public Article(Planets planets) {
        this.planets = planets;
    }

    public Article(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Planets getPlanets() {
        return planets;
    }

    public void setPlanets(Planets planets) {
        this.planets = planets;
    }
}
