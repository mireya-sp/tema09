package com.mireyaserrano.tema09.Map;

public class MainMap {

    public static void main(String[] args){
        AgendaContactos agendaContactos = new AgendaContactos();
        agendaContactos.add(new Contacto("602217718", "Mire", "mail"));
        agendaContactos.add(new Contacto("123456789", "Perico", "parquecorreos@gmail.com"));
        System.out.println(agendaContactos.buscar("602217718"));
        System.out.println(agendaContactos.getAgenda());
    }
}
