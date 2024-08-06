package com.example.duan;

import Entity.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OrderItemController {

    @FXML
    private Label productLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label totalAmountLabel;

    @FXML
    private Button paidButton;

    @FXML
    private Button cancelButton;

    private Order order;  // Đúng kiểu dữ liệu là Order

    @FXML
    private void initialize() {
        // Xử lý logic cho các nút, nếu cần
        paidButton.setOnAction(event -> handlePaidAction());
        cancelButton.setOnAction(event -> handleCancelAction());
    }

    public void setOrder(Order order) {
        this.order = order;  // Cập nhật biến order
        productLabel.setText(order.getProduct());
        quantityLabel.setText("Số lượng: " + order.getQuantity());
        totalAmountLabel.setText("Tổng tiền: $" + order.getTotalAmount());
        // Cập nhật trạng thái nút nếu cần

//
//        boolean isPending = "Chưa thanh toán".equals(order.getStatus());
//        paidButton.setDisable(!isPending);
//        cancelButton.setDisable(!isPending);

    }

    private void handlePaidAction() {
        // Xử lý hành động khi nút "Đã thanh toán" được nhấn
        if (order != null) {
            order.setStatus("Đã thanh toán");
            System.out.println("Đã thanh toán");
            updateButtonStatus();
        }
    }

    private void handleCancelAction() {
        // Xử lý hành động khi nút "Hủy đơn" được nhấn
        if (order != null) {
            order.setStatus("Hủy đơn");
            System.out.println("Hủy đơn");
            updateButtonStatus();
        }
    }





    private void updateButtonStatus() {
        if (order != null) {
            switch (order.getStatus()) {
                case "Đã thanh toán", "Hủy đơn":
                    paidButton.setDisable(true);
                    cancelButton.setDisable(true);
                    break;
                default:
                    paidButton.setDisable(false);
                    cancelButton.setDisable(false);
                    break;
            }
        } else {
            paidButton.setDisable(false);
            cancelButton.setDisable(false);
        }
    }

}
