/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layananasuransi;

/**
 *
 * @author MyBook Z Series
 */
public class Polis {
    private int id;
    private Nasabah nasabah;
    private Asuransi asuransi;

    public Polis(int id, Nasabah nasabah, Asuransi asuransi) {
        this.id = id;
        this.nasabah = nasabah;
        this.asuransi = asuransi;
    }

    public int getId() {
        return id;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public Asuransi getAsuransi() {
        return asuransi;
    }
}