package com.rest.practice.util;

import com.rest.practice.models.MenuItem;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;

public class MenuItemUtil  {
    public List<MenuItem> sortByPriceHighest(List<MenuItem> menuItems ) {
        menuItems.sort(Comparator.comparingDouble(MenuItem::getPrice));
        return menuItems;
    }

    public List<MenuItem> sortByPriceLowest(List<MenuItem> menuItems ) {
        menuItems.sort(Comparator.comparingDouble(MenuItem::getPrice).reversed());
        return menuItems;
    }

    public List<MenuItem> sortByPriceHighestStream(List<MenuItem> menuItems ) {
        menuItems = menuItems.stream().sorted(Comparator
                .comparing(MenuItem::getPrice)).collect(Collectors.toList());
        return menuItems;
    }

    public List<MenuItem> sortByPriceLowestStream(List<MenuItem> menuItems ) {
        menuItems = menuItems.stream().sorted(Comparator
                .comparing(MenuItem::getPrice).reversed()).collect(Collectors.toList());
        return menuItems;
    }

    public List<MenuItem> filterPrice(List<MenuItem> menuItems, double price) {
        return menuItems.stream()
                .filter(item -> item.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<MenuItem> filterAllergies(List<MenuItem> menuItems, String allergies) {
        return menuItems.stream()
                .filter(item -> !item.getAllergies().equals(allergies))
                .collect(Collectors.toList());
    }
}
