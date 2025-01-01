package jpabook.jpashop.domain;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable
@Getter //값 타입은 변경이 불가능 하게 설계해야해서 @Setter은 안넣음
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
