package lt.bit.products.ui.model;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class OrderItem {

    private String id;
    private UUID productId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    private double Quantity;
}
