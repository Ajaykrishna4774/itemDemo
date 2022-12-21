package com.capgemini.demo.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.demo.entity.Item;
import com.capgemini.demo.repository.ItemRepository;


@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemRepository itemRepo;

    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Item> getAllItems(){
        return itemRepo.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public Item getItem(@RequestParam("itemId") int itemId){
        return itemRepo.getItem(itemId);
    }

    @PostMapping("/addItem")
    public String addItem(@RequestBody Item body){
        if(itemRepo.addItem(body) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @DeleteMapping("/deteteItem")
    public String deteteItem(@RequestParam("itemId") int itemId){
        if(itemRepo.deleteItem(itemId) >= 1){
            return "Item Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}