/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.model;

/**
 *
 * @author informatica
 */
public class Player {
    private Integer id;
    private String name;
    private Integer age;
    private Integer matches;

    public Player() {
    }

    public Player(Integer id, String name, Integer age, Integer matches) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.matches = matches;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }
    
    
    
}
