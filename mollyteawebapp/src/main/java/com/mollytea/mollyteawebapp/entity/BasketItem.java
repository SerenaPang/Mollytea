package com.mollytea.mollyteawebapp.entity;
 
import java.math.BigDecimal;
 
import lombok.Data;
 
@Data
public class BasketItem {
 
    private final Product product;
    private final int qty;
 
    public BigDecimal getTotal() {
        return this.product.getPrice().multiply(BigDecimal.valueOf(qty));
    }
}
 