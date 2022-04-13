package com.example.projectdam;

public class Materials {
    private String nume;
    private double cost;
    private int imagine;
    private int contor = 0;
    Materials(String nume,double cost,int imagine)
    {
        this.nume=nume;
        this.cost=cost;
        this.imagine=imagine;
    }
    public void setNume(String nume)
    {
        this.nume=nume;
    }
    public void setCost(double cost)
    {
        this.cost=cost;
    }
    public void setImagine(int imagine)
    {
        this.imagine=imagine;
    }
    public String getNume()
    {
        return nume;
    }
    public double getCost()
    {
        return cost;
    }
    public int getImagine()
    {
        return imagine;
    }
    public void setContor(int contor){
        this.contor = contor;
    }
    public int getContor()
    {
        return  contor;
    }
}
