package org.anakrimba.challenge.challengemp.controller;


import org.anakrimba.challenge.challengemp.model.Weapon;
import org.anakrimba.challenge.challengemp.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class WeaponController {

    @Autowired
    WeaponRepository weaponRepository;

    @GetMapping("/weapons")
    public ResponseEntity<List<Weapon>> getAllCategory() {
        List<Weapon> category = new ArrayList<Weapon>();

        weaponRepository.findAll().forEach(category::add);

        if (category.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @GetMapping("/weapons/{id}")
    public ResponseEntity<Weapon>getTutorialById(@PathVariable("id")long id) {
        Optional<Weapon> weaponData = weaponRepository.findById(id);

        if (weaponData.isPresent()) {
            return new ResponseEntity<>(weaponData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/weapons")
    public  ResponseEntity<Weapon> createWeapon(@RequestBody Weapon weapon) {
        try {
            Weapon _weapon=weaponRepository.save(weapon);
            return new ResponseEntity<Weapon>(_weapon,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/weapon/{id}")
    public ResponseEntity<Weapon>updateWeapon(@PathVariable("id")long id,@RequestBody Weapon weapon) {
        Optional<Weapon> weaponData = weaponRepository.findById(id);

        if (weaponData.isPresent()){
            Weapon _weapon = weaponData.get();
            _weapon.setWeapon(weapon.getWeapon());
            _weapon.setChategory(weapon.getChategory());
            _weapon.setRole(weapon.getRole());
            return new ResponseEntity<>(weaponRepository.save(_weapon), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Weapons/{id}")
    public ResponseEntity<HttpStatus>deleteWeapon(@PathVariable("id")long id) {
        try {
            weaponRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Weapons")
    public ResponseEntity<HttpStatus>deleteAllweapons(){
        try {
            weaponRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
