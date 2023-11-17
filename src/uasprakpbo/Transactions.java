/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasprakpbo;

/**
 *
 * @author marti
 */
public class Transactions {
    private int id;
    private Users user;
    private Games game;

    public Transactions(int id, Users user, Games game) {
        this.id = id;
        this.user = user;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Transactions{" + "id=" + id + ", user=" + user + ", game=" + game + '}';
    } 
}
