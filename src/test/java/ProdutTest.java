import com.company.Entities.Price;
import com.company.Entities.Product;
import com.company.Offer.OfferStrategy;
import com.company.Offer.OfferStrategyFactory;
import com.company.Offer.OfferStrategyFactoryImpl;
import com.company.Order.OrderItem;
import com.company.Order.OrderList;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProdutTest {

    private OfferStrategyFactory offerStrategyFactory;
    private OfferStrategy offerStrategy;
    private OrderItem orderItem;
    private OrderList orderList;

    @Test()
    public void testNormalOfferStrategy(){

        offerStrategyFactory = new OfferStrategyFactoryImpl();

        Product p = new Product(2500,"Product 1", Price.of(132));

        OrderList ol = new OrderList(offerStrategyFactory);
        ol.addOrderItem(p,3);

        Price expectedPrice = Price.of(396);
        assertEquals(expectedPrice,ol.getTotalPrice());

    }

    @Test()
    public void testThirdOneFreeOfferStrategy(){
        offerStrategyFactory = new OfferStrategyFactoryImpl();

        Product p = new Product(7500,"Product 2", Price.of(250));

        OrderList ol = new OrderList(offerStrategyFactory);
        ol.addOrderItem(p,5);

        Price expectedPrice = Price.of(1000);
        assertEquals(expectedPrice,ol.getTotalPrice());

        ol.addOrderItem(p,1);
        assertEquals(expectedPrice,ol.getTotalPrice());

    }

    @Test()
    public void testAllOfferStrategy(){
        offerStrategyFactory = new OfferStrategyFactoryImpl();
        Product p1 = new Product(8000,"Product 3", Price.of(175));
        Product p2 = new Product(3000,"Product 4", Price.of(15));

        OrderList ol = new OrderList(offerStrategyFactory);

        ol.addOrderItem(p1,14);
        Price expectedPrice1 = Price.of(1750);
        assertEquals(expectedPrice1,ol.getTotalPrice());

        ol.addOrderItem(p2,20);
        Price expectedPrice2 = Price.of(1750+(20*15));
        assertEquals(expectedPrice2,ol.getTotalPrice());

        ol.addOrderItem(p1,2);
        Price expectedPrice3 = Price.of(1750+(20*15)+175);
        assertEquals(expectedPrice3,ol.getTotalPrice());


    }

}


