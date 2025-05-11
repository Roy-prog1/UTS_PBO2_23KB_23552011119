/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layananasuransi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MyBook Z Series
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Nasabah> daftarNasabah = new ArrayList<>();
    static List<Polis> daftarPolis = new ArrayList<>();
    static List<Klaim> daftarKlaim = new ArrayList<>();

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang newline

            switch (pilihan) {
                case 1 -> tambahNasabah();
                case 2 -> buatPolis();
                case 3 -> buatKlaim();
                case 4 -> tampilkanData();
                case 5 -> System.out.println("Terima kasih. Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    static void tampilkanMenu() {
        System.out.println("\n=== LAYANAN ASURANSI ===");
        System.out.println("1. Tambah Nasabah");
        System.out.println("2. Buat Polis Asuransi");
        System.out.println("3. Buat Klaim Asuransi");
        System.out.println("4. Tampilkan Data");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    static void tambahNasabah() {
        System.out.print("ID Nasabah: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Nasabah: ");
        String nama = scanner.nextLine();

        System.out.print("Umur: ");
        int umur = scanner.nextInt();

        daftarNasabah.add(new Nasabah(id, nama, umur));
        System.out.println("Nasabah berhasil ditambahkan.");
    }

    static void buatPolis() {
        System.out.print("ID Polis: ");
        int id = scanner.nextInt();

        System.out.print("ID Nasabah: ");
        int nasabahId = scanner.nextInt();
        scanner.nextLine();

        Nasabah nasabah = cariNasabahById(nasabahId);
        if (nasabah == null) {
            System.out.println("Nasabah tidak ditemukan.");
            return;
        }

        System.out.print("Jenis Asuransi (Kesehatan/Jiwa): ");
        String jenis = scanner.nextLine();

        Asuransi asuransi;
        if (jenis.equalsIgnoreCase("Kesehatan")) {
            asuransi = new Kesehatan();
        } else if (jenis.equalsIgnoreCase("Jiwa")) {
            asuransi = new Jiwa();
        } else {
            System.out.println("Jenis asuransi tidak valid.");
            return;
        }

        asuransi.hitungPremi();
        daftarPolis.add(new Polis(id, nasabah, asuransi));
        System.out.println("Polis berhasil dibuat.");
    }

    static void buatKlaim() {
        System.out.print("ID Klaim: ");
        int id = scanner.nextInt();

        System.out.print("ID Polis: ");
        int polisId = scanner.nextInt();
        scanner.nextLine();

        Polis polis = cariPolisById(polisId);
        if (polis == null) {
            System.out.println("Polis tidak ditemukan.");
            return;
        }

        System.out.print("Status Klaim (Diproses/Disetujui/Ditolak): ");
        String status = scanner.nextLine();

        Klaim klaim = new Klaim(id, polis, new Date(), status);
        daftarKlaim.add(klaim);
        System.out.println("Klaim berhasil dibuat.");
    }

    static void tampilkanData() {
        System.out.println("\n--- NASABAH ---");
        for (Nasabah n : daftarNasabah) {
            System.out.println("ID: " + n.getId() + ", Nama: " + n.getNama() + ", Umur: " + n.getUmur());
        }

        System.out.println("\n--- POLIS ---");
        for (Polis p : daftarPolis) {
            System.out.println("ID: " + p.getId() + ", Nasabah: " + p.getNasabah().getNama() +
                ", Jenis: " + p.getAsuransi().getJenis() + ", Premi: Rp" + p.getAsuransi().getPremi());
        }

        System.out.println("\n--- KLAIM ---");
        for (Klaim k : daftarKlaim) {
            System.out.println("ID: " + k.getId() + ", Polis ID: " + k.getPolis().getId() +
                ", Tanggal: " + k.getTanggal() + ", Status: " + k.getStatus());
        }
    }

    static Nasabah cariNasabahById(int id) {
        for (Nasabah n : daftarNasabah) {
            if (n.getId() == id) return n;
        }
        return null;
    }

    static Polis cariPolisById(int id) {
        for (Polis p : daftarPolis) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}