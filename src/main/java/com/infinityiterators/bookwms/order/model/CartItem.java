package com.infinityiterators.bookwms.order.model;

import com.infinityiterators.bookwms.order.dto.CartItemDTO;

public class CartItem {
    private int cartItemId;
    private int cartId;
    private int bookId;
    private int quantity;

    // 기본 생성자
    public CartItem() {
    }

    // 매개변수가 있는 생성자
    public CartItem(int cartItemId, int cartId, int bookId, int quantity) {
        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", cartId=" + cartId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                '}';
    }

    // DTO로 변환
    public CartItemDTO toCartItemDTO() {
        return new CartItemDTO(cartItemId, cartId, bookId, quantity);
    }
}
