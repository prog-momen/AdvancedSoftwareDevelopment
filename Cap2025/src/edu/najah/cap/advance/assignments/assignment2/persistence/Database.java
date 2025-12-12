package edu.najah.cap.advance.assignments.assignment2.persistence;

public class Database {

    public void save(String connId, String id, String data) {
        System.out.println("[Conn " + connId + "] executing save: " + id + ":" + data);
    }
}
