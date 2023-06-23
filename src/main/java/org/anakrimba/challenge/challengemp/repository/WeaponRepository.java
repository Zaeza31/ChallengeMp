package org.anakrimba.challenge.challengemp.repository;

import org.anakrimba.challenge.challengemp.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeaponRepository extends JpaRepository<Weapon,Long> {

List<Weapon>findByWeaponContaining(String weapon);
}
