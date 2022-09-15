package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.Orders;
import com.lowes.leap.renohacksapi.entity.OrdersProduct;
import com.lowes.leap.renohacksapi.entity.Product;
import com.lowes.leap.renohacksapi.model.CartDetails;
import com.lowes.leap.renohacksapi.model.OrdersDetails;
import com.lowes.leap.renohacksapi.model.ProductCartDetails;
import com.lowes.leap.renohacksapi.model.ProductOrdersDetails;
import com.lowes.leap.renohacksapi.repository.CartProductRepository;
import com.lowes.leap.renohacksapi.repository.OrdersProductRepository;
import com.lowes.leap.renohacksapi.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;

    @Autowired
    OrdersProductRepository ordersProductRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders addNewOrders() {
        Orders newOrders = new Orders();
        return ordersRepository.save(newOrders);
    }

    public OrdersDetails getOrdersDetails(int ordersId) {
        List<OrdersProduct> allOrdersProduct = ordersProductRepository.findByOrdersOrdersId(ordersId);
        OrdersDetails ordersDetails = new OrdersDetails();
        ordersDetails.setOrdersId(ordersId);
        ArrayList<ProductOrdersDetails> productOrdersDetailsList = new ArrayList<>();

        for(int i = 0; i < allOrdersProduct.size(); i++){
            OrdersProduct currOrdersProduct = allOrdersProduct.get(i);
            ProductOrdersDetails productOrdersDetails = new ProductOrdersDetails();

            productOrdersDetails.setProductId(currOrdersProduct.getProduct().getProductId());
            productOrdersDetails.setProductName(currOrdersProduct.getProduct().getProductName());
            productOrdersDetails.setProductDescription(currOrdersProduct.getProduct().getProductDescription());
            productOrdersDetails.setProductPrice(currOrdersProduct.getProduct().getProductPrice());
            productOrdersDetails.setProductModelNo(currOrdersProduct.getProduct().getProductModelNo());
            productOrdersDetails.setProductOrdersQuantity(currOrdersProduct.getProductQuantity());
            productOrdersDetails.setProductFeature(currOrdersProduct.getProduct().getProductFeature());
            productOrdersDetails.setOrdersProductId(currOrdersProduct.getOrdersProductId());

            productOrdersDetailsList.add(productOrdersDetails);
        }
        ordersDetails.setProductOrdersDetailsList(productOrdersDetailsList);
        return ordersDetails;
    }


    public void addAllProductsFromCartToOrders(int cartId, int ordersId) {

        CartDetails cartDetails = cartService.getCartDetails(cartId);
        List<ProductCartDetails> productCartDetailsList = cartDetails.getProductCartDetailsList();

        for(int i = 0; i < productCartDetailsList.size(); i++){
            ProductCartDetails productCartDetails = productCartDetailsList.get(i);

            Orders orders = ordersRepository.findByOrdersId(ordersId);
            Product product = (Product) productService.getByProductId(productCartDetails.getProductId());

            OrdersProduct ordersProduct = OrdersProduct.builder()
                    .orders(orders)
                    .product(product)
                    .productQuantity(productCartDetails.getProductCartQuantity())
                    .build();

            ordersProductRepository.save(ordersProduct);


            int cartProductId = productCartDetails.getCartProductId();
            cartProductRepository.deleteById(cartProductId);
        }

    }
}