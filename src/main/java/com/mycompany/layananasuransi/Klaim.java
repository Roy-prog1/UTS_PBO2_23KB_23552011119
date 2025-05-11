/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layananasuransi;

import java.util.Date;

/**
 *
 * @author MyBook Z Series
 */
public class Klaim {
    private final int id;
    private final Polis polis;
    private final Date tanggal;
    private final String status;

    public Klaim(int id, Polis polis, Date tanggal, String status) {
        this.id = id;
        this.polis = polis;
        this.tanggal = tanggal;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Polis getPolis() {
        return polis;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }
}