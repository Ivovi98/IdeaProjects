package org.cellphone;

import java.util.Objects;

public class Cellphone {
    //ATTRIBUTI
    private String operator = "";
    private String cellNumber = "";
    //COSTRUTTORE
    public Cellphone(String operator, String cellNumber) {
        this.operator = operator;
        this.cellNumber = cellNumber;
    }
    //COSTRUTTORE
    public Cellphone() {}
    //GETTER E SETTER
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getCellNumber() {
        return cellNumber;
    }
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cellphone cellphone = (Cellphone) o;
        return operator.equals(cellphone.operator) && cellNumber.equals(cellphone.cellNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(operator, cellNumber);
    }
    //TOSTRING
    @Override
    public String toString() {
        return "Cellphone:" +
                "operator='" + operator + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                '}';
    }

    //METODI

    public static double setCost(String op1, String op2){
        double pricePerMinute = 0;
        if(op1.equals("TIMMY")){
            if(op2.equals("TIMMY")) {
                pricePerMinute = 0.05;
            }else if(op2.equals("Megafon")) {
                pricePerMinute = 0.15;
            }else if(op2.equals("Odissey")) {
                pricePerMinute = 0.20;
            }
        }else if(op1.equals("Odissey")){
            if(op2.equals("TIMMY")) {
                pricePerMinute = 0.15;
            }else if(op2.equals("Megafon")) {
                pricePerMinute = 0.15;
            }else if(op2.equals("Odissey")) {
                pricePerMinute = 0.01;
            }
        }else{//op1.equals("Megafon");
            if(op2.equals("TIMMY")) {
                pricePerMinute = 0.25;
            }else if(op2.equals("Megafon")) {
                pricePerMinute = 0.10;
            }else if(op2.equals("Odissey")) {
                pricePerMinute = 0.30;
            }
        }
        return pricePerMinute;
    }

    public double getCost(String op1, String op2, int num){
        double priceCall = 0;
        priceCall = setCost(op1,op2)*num;
        return priceCall;
    }
}
    //ATTRIBUTI

    //COSTRUTTORE

    //GETTER E SETTER

    //EQUALS E HASHCODE

    //TOSTRING

    //METODI
