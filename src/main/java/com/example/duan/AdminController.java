package com.example.duan;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;


public class AdminController {

    @FXML
    private Button addProductButton;
    @FXML
    private Button viewOrdersButton;
    @FXML
    private Button manageUsersButton;
    @FXML
    private TableView<?> productTable; // Thay đổi kiểu của TableView nếu cần
    @FXML
    private TableColumn<?, ?> productNameColumn;
    @FXML
    private TableColumn<?, ?> productPriceColumn;
    @FXML
    private TableColumn<?, ?> productQuantityColumn;
    @FXML
    private TableColumn<?, ?> productActionColumn;

    @FXML
    private void handleAddProduct() {
        // Xử lý thêm sản phẩm
        System.out.println("Thêm sản phẩm");
    }

    @FXML
    private void handleViewOrders() {
        // Xử lý xem đơn hàng
        System.out.println("Xem đơn hàng");
    }

    @FXML
    private void handleManageUsers() {
        // Xử lý quản lý người dùng
        System.out.println("Quản lý người dùng");
    }
}
