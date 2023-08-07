package com.Agenda.Agenda.Klinik.Telkomedika.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Agenda")
public class AgendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long version;
    @Column(name = "id")
    private Long id;
    @Column(name = "judul")
    private String judul;
    @Column(name = "deskripsi")
    private String deskripsi;
    @Column(name = "waktu")
    private String waktu;

    public AgendaEntity() {
    }

    public AgendaEntity(Long id, String judul, String deskripsi, String waktu) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.waktu = waktu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
