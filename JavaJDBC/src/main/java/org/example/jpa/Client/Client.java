package org.example.jpa.Client;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome")
    private String name;
    @Column(name = "idade")
    private String age;
    @Column(name = "endereco")
    private String address;
    public Client (){}
    public Client(String name,String age,String address){
        this.name =name;
        this.age = age;
        this.address =address;
    }
    public Client(int id ,String name,String age,String address){
        this.id = id;
        this.name =name;
        this.age = age;
        this.address =address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
