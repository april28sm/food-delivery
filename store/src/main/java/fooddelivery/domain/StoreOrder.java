package fooddelivery.domain;

import fooddelivery.domain.배달시작됨;
import fooddelivery.domain.Accepted;
import fooddelivery.domain.Cooked;
import fooddelivery.domain.쿠폰발행됨;
import fooddelivery.domain.Rejected;
import fooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String test;

    @PostPersist
    public void onPostPersist(){


        배달시작됨 배달시작됨 = new 배달시작됨(this);
        배달시작됨.publishAfterCommit();



        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        쿠폰발행됨 쿠폰발행됨 = new 쿠폰발행됨(this);
        쿠폰발행됨.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }



    public void accept(){
    }
    public void reject(){
    }
    public void startCook(){
    }
    public void finishCook(){
    }

    public static void addToOrderList(Paid paid){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }
    public static void notifyOrderCancelled(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }


}
