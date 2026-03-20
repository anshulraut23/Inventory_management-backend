package com.example.main.dto;

public class DashboardStats {

    private long totalItems;

    private long totalStock;

    private long lowStockItems;

    public DashboardStats(long totalItems, long totalStock, long lowStockItems) {
        this.totalItems = totalItems;
        this.totalStock = totalStock;
        this.lowStockItems = lowStockItems;
    }

    public long getTotalItems() {
        return totalItems;
    }
    
    

    public long getTotalStock() {
        return totalStock;
    }

    public long getLowStockItems() {
        return lowStockItems;
    }
}