package com.mollytea.mollyteawebapp.entity;
 
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
 
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
 
import com.mollytea.mollyteawebapp.service.MenuService;
 
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class SessionBasket implements Basket {
 
    private final Map<Long, BasketItem> items = new ConcurrentHashMap<>();
    private final MenuService menuService;
 
    public SessionBasket(MenuService menuService) {
        this.menuService = menuService;
    }
 
    @Override
    public void add(Long id) {
        Product product = this.menuService.getProductById(id);
        if (product == null) return;
 
        this.items.compute(id, (existingId, existingItem) -> {
            if (existingItem == null) {
                return new BasketItem(product, 1);
            }
            return new BasketItem(existingItem.getProduct(), existingItem.getQty() + 1);
        });
    }
 
    @Override
    public int getTotalItems() {
        return this.items.values().stream()
                .mapToInt(BasketItem::getQty)
                .sum();
    }
 
    @Override
    public Collection<BasketItem> getItems() {
        return this.items.values();
    }
 
    @Override
    public void remove(Long id) {
         this.items.computeIfPresent(id, (productId, existingItem) -> {
            if (existingItem.getQty() == 1) {
                return null;
            }

            return new BasketItem(existingItem.getProduct(), existingItem.getQty() - 1);
        });
    }
 
    @Override
    public void clear() {
        this.items.clear();
    }
}
 