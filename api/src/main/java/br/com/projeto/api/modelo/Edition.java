//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.projeto.api.modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "editions")
public class Edition{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private int year;
    private Date start_date;
    private Date end_date;
    private String city;
    @OneToOne
    private User users;

    @OneToMany
    @JoinColumn(name = "Edition_ID", referencedColumnName = "ID")
    private List<Activitie> activities;

    public Edition() {
    }

    public int getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartDate() {
        return this.start_date;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEndDate() {
        return this.end_date;
    }

    public void setEndDate(Date end_date) {
        this.end_date = end_date;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUsers() {
        return this.users;
    }

    public void setUsers(User user) {
        this.users = user;
    }

    public List<Activitie> getActivities() {
        return this.activities;
    }

    public void setActivities(List<Activitie> activities) {
        this.activities = activities;
    }

    public Activitie getActivitieById(int id) {
        for (Activitie atividade : activities) {
            if (atividade.getId() == id) {
                return atividade;
            }
        }
        // Retorna null se nenhuma atividade com o ID especificado for encontrada.
        return null;
    }

    public void addActivitie(Activitie activitie) {
        this.activities.add(activitie);
    }

    public void removeActivitie(Activitie activitie) {
        this.activities.remove(activitie);
    }

}