/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layananasuransi;

/**
 *
 * @author MyBook Z Series
 */
public class Kesehatan extends Asuransi {
    public Kesehatan() {
        super("Kesehatan");
    }

    @Override
    public double hitungPremi() {
        premi = 500000; // contoh premi tetap
        return premi;
    }
}