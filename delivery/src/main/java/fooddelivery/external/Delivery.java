package fooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Delivery {

    private Long id;
    private String address;
    private Long orderId;
    private String riderId;
}


