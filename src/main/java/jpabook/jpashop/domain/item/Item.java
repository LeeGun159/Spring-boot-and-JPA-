package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로작 =//

    /**
     * stock 증가
     */

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    /**
     * stock 감소
     */
    public void removeStock (int quantity) {
        int restock = this.stockQuantity - quantity;
        if (restock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restock;
    }
}
