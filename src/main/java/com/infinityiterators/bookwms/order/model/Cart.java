package com.infinityiterators.bookwms.order.model;

import com.infinityiterators.bookwms.order.dto.CartDTO;
import com.infinityiterators.bookwms.order.dto.CartItemDTO;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int cartId;
    private int userCode;
    private List<CartItemDTO> items; // 장바구니 항목 리스트

    public Cart(int cartId, int userCode) {
        this.cartId = cartId;
        this.userCode = userCode;
        this.items = new ArrayList<CartItemDTO>();
    }

    // Getters and Setters
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    // 장바구니 항목 추가
    public void addCartItem(CartItemDTO cartItem) {
        items.add(cartItem);
    }

    // 장바구니 항목 제거
    public void removeCartItem(CartItem item) {
        items.remove(item);
    }

    // 장바구니 항목 업데이트
    public void updateCartItem(int bookId, int quantity) {
        for (CartItemDTO item : items) {
            if (item.getBookId() == bookId) {
                item.setQuantity(quantity);
                break;
            }
        }
    }

    // 장바구니 항목 수 반환
    public int getTotalItems() {
        return items.size();
    }

    // 장바구니 총 금액 계산 (예시로 단순히 수량의 합을 반환)
    public int getTotalAmount() {
        int total = 0;
        for (CartItemDTO item : items) {
            total += item.getQuantity();
        }
        return total;
    }

    // 장바구니를 주문으로 전환
    public void checkout() {
        // 주문 생성 로직 구현
    }

    // DTO로 변환

}
