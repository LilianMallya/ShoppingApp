# 🛒 Shopping List Manager (Android App)

A mobile application for managing shopping lists with product quantity tracking.

## 📱 Features
- **Product Management**:
  - Add new products with name, quantity, and unit type
  - Edit existing product details
  - Delete products from the list
- **Quantity Control**:
  - Increase/decrease product quantities
  - Supports different unit types (kg, liters, units)
- **RecyclerView**:
  - Efficiently displays long lists of products
  - Smooth scrolling performance

## 🛠️ Technical Implementation
- **Android Components**:
  - Activities (`MainActivity`, `AddProductActivity`, `UpdateProductActivity`)
  - RecyclerView with custom Adapter
  - Intent-based navigation
- **Core Functionality**:
  - CRUD operations for shopping items
  - Quantity modification with +/- buttons
  - Data persistence through serialization
