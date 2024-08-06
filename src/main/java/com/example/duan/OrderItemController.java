package com.example.duan;

import Entity.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Optional;

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


    }

    private void handlePaidAction() {
        // Xử lý hành động khi nút "Đã thanh toán" được nhấn
        if (order != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận");
            alert.setHeaderText(null);
            alert.setContentText("Bạn có chắc chắn muốn chuyển trạng thái đơn hàng thành Đã thanh toán?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                order.setStatus("Đã thanh toán");
                updateButtonStatus();
            }

        }
    }

    private void handleCancelAction() {
        if (order != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận");
            alert.setHeaderText(null);
            alert.setContentText("Bạn có chắc chắn muốn chuyển trạng thái đơn hàng thành Hủy đơn?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                order.setStatus("Hủy đơn");
                updateButtonStatus();
            }
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


