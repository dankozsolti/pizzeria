package hu.ulyssys.pizzeria.util;

import hu.ulyssys.pizzeria.entity.Order;
import hu.ulyssys.pizzeria.entity.Pizza;
import hu.ulyssys.pizzeria.rest.model.OrderModel;
import hu.ulyssys.pizzeria.rest.model.PizzaModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderModelMapperBean extends CoreModelMapperBean<OrderModel, Order>{

    @Override
    public OrderModel createModelFromEntity(Order entity) {
        OrderModel orderModel = super.createModelFromEntity(entity);
        orderModel.setDeliveryDate(entity.getDeliveryDate());
        orderModel.setCity(entity.getCity());
        orderModel.setStreet(entity.getStreet());
        orderModel.setStreetType(entity.getStreetType());
        orderModel.setHouseNumber(entity.getHouseNumber());
        orderModel.setCourier(entity.getCourier());
        orderModel.setPizzas(entity.getPizzaList());
        return orderModel;
    }

    @Override
    public void populateEntityFromModel(Order entity, OrderModel model){
        super.populateEntityFromModel(entity,model);
        entity.setDeliveryDate(model.getDeliveryDate());
        entity.setCity(model.getCity());
        entity.setStreet(model.getStreet());
        entity.setStreetType(model.getStreetType());
        entity.setHouseNumber(model.getHouseNumber());
        entity.setCourier(model.getCourier());
        entity.setPizzaList(model.getPizzas());

    }

    @Override
    public OrderModel initNewModel() {
        return new OrderModel();
    }

}
