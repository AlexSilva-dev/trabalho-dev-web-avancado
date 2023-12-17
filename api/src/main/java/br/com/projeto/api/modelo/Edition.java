//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.projeto.api.modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
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
    private User organizer;

    @OneToOne
    private Event event;

    @OneToMany
    @JoinColumn(name = "User_ID", referencedColumnName = "id")
    private List<User> users = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "Edition_ID", referencedColumnName = "id")
    private List<Activitie> activities = new ArrayList<>();

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

    public User getOrganizer() {
        return this.organizer;
    }

    public void setOrganizer(User user) {
        this.organizer = user;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Activitie> getActivities() {
        return activities;
    }

    public void setActivities(List<Activitie> activities) {
        this.activities = activities;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public List<Edition> getEventInEdition(Iterable<Edition> editions, int id) {
        List<Edition> result = new ArrayList<>();
        for (Edition edition : editions) {
            Event event = edition.getEvent();
            if (event != null && event.getId() == id) {
                result.add(edition);
            }
        }
        return result;
    }

    public void adicionaUsuario(User user){
        users.add(user);
    }

    public void addActivities(Activitie activitie){
        activities.add(activitie);
    }

    public void addActivitie(Activitie activitie) {
        this.activities.add(activitie);
    }

    public void removeActivitie(Activitie activitie) {
        this.activities.remove(activitie);
    }

}