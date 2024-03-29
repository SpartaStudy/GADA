package com.maple.mapleservice.dto.model.character.cashitem;

import lombok.Getter;

import java.util.List;

@Getter
public class CashItemEquipment {
    String cash_item_equipment_part;
    String cash_item_equipment_slot;
    String cash_item_name;
    String cash_item_icon;
    String cash_item_description;
    String date_expire;
    String date_option_expire;
    String cash_item_label;
    List<CashItemOption> cash_item_option;
    CashItemColoring cash_item_coloring_prism;
}
