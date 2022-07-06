package lt.bit.products.ui.service.error;

import lt.bit.products.ui.model.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.*;
import java.util.stream.Collectors;

@Service
@SessionAttributes("cartItems")
public class CartService {
    private static final Logger LOG = LoggerFactory.getLogger(CartService.class);
    private Map<UUID, CartItem> cartItems = new HashMap<>();

    public void addToCart(UUID productId, String productName) {
        CartItem item;
        if(cartItems.containsKey(productId)) {
            item = cartItems.get(productId);
            item.setCount(item.getCount() + 1);
        }else{
            item = new CartItem(productId, productName,1);
        }
        cartItems.put(productId, item);
        LOG.info("Cart" + cartItems);
        }
       public List<CartItem> getCartItems() {
            UUID uuid1 = UUID.randomUUID();
            UUID uuid2 = UUID.randomUUID();
            UUID uuid3 = UUID.randomUUID();

            cartItems.put(uuid1, new CartItem(uuid1,"zzz",1));
            cartItems.put(uuid1, new CartItem(uuid2,"aaa",1));
            cartItems.put(uuid1, new CartItem(uuid3,"bbb",1));

           return this.cartItems.values().stream()
                   .sorted(Comparator.comparing(CartItem::getProductName))
                   .collect(Collectors.toList());
       }

    }

