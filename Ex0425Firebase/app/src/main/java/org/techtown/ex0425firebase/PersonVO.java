package org.techtown.ex0425firebase;

public class PersonVO {

    private String name;
    private  int age;
    private boolean gender;

    //Firebase 데이터 베이스에서 personVO타입으로 읽어올 때
    //기본 생성자는 반드시  정의가되어있어야  읽어올 수 있다.
    // 기본생성자
    private  PersonVO(){}

    //alt+inset (생성자,getter,setter)

    public PersonVO(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    //이 객체에 어떤 데이터가 들어있는지 확인하는 용도로 toString
    @Override
    public String toString() {
        return "PersonVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
