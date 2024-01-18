export const armorArray = [
  "Padded",
  "Leather",
  "Studded Leather",
  "Hide",
  "Chain Shirt",
  "Scale Mail",
  "Breastplate",
  "Half-Plate",
  "Ring Mail",
  "Splint",
  "Plate",
];
export const magicArmorArray = [
  "Adamantine Armor",
  "Mithral Armor",
  "Armor of Resistance",
  "Armor of Vulnerability",
  "Elven Chain",
  "Glamoured Studded Leather",
  "Shield of Missile Attraction",
  "Animated Shield",
  "Dragon Scale Mail",
  "Dwarven Plate",
  "Demon Armor",
  "Spellguard Shield",
  "Armor of Invulnerability",
  "Plate Armor of Etherealness",
];
export const weaponArray = [
  "Club",
  "Dagger",
  "Greatclub",
  "Handaxe",
  "Javelin",
  "Light Hammer",
  "Mace",
  "Quarterstaff",
  "Sickle",
  "Spear",
  "Light Crossbow",
  "Dart",
  "Shortbow",
  "Blowgun",
  "Hand Crossbow",
  "Heavy Crossbow",
  "Longbow",
  "Battleaxe",
  "Flail",
  "Glaive",
  "Greataxe",
  "Greatsword",
  "Halberd",
  "Lance",
  "Longsword",
  "Maul",
  "Morningstar",
  "Pike",
  "Rapier",
  "Scimitar",
  "Shortsword",
  "Trident",
  "War Pick",
  "Warhammer",
  "Whip",
];
export const magicWeaponArray = [
  "Javelin of Lightning",
  "Trident of Fish Command",
  "Dagger of Venom",
  "Dragon Slayer",
  "Flame Tongue",
  "Giant Slayer",
  "Berserker Axe",
  "Mace of Disruption",
  "Mace of Smiting",
  "Mace of Terror",
  "Sun Blade",
  "Sword of Life Stealing",
  "Sword of Wounding",
  "Dwarven Thrower",
  "Scimitar of Speed",
  "Dancing Sword",
  "Frost Brand",
  "Nine Lives Stealer",
  "Oathbow",
  "Sword of Sharpness",
  "Defender",
  "Hammer of Thunderbolts",
  "Holy Avenger",
  "Luck Blade",
  "Vorpal Sword",
  "Wand of Magic Detection",
  "Wand of Magic Missiles",
  "Wand of Secrets",
  "Wand of the War Mage",
  "Wand of Web",
  "Wand of Binding",
  "Wand of Enemy Detection",
  "Wand of Fear",
  "Wand of Fireballs",
  "Wand of Lightning Bolts",
  "Wand of Paralysis",
  "Wand of Wonder",
  "Wand of Polymorph",
  "Staff of the Python",
  "Staff of Charming",
  "Staff of Healing",
  "Staff of Swarming Insects",
  "Staff of the Woodlands",
  "Staff of Withering",
  "Elemental Staff",
  "Staff of the Magi",
];
export const treasures = [
  {
    id: 0, //Key for jsx
    name: "Savoury Salami",
    description: "Satisfies hunger",
    whenInfused:
      "Perfectly good salami. NPCs who eat it at a campfire gain a +1 morale bonus for the first combat of the next day, and everyone who eat it gain +1 to damage for that first combat of the next day.",
  },
  {
    id: 1, //Key for jsx
    name: "Cook's Spoon",
    description: "Stirs pots. -4 to hit, 1d2 dmg as a weapon.",
    whenInfused:
      "If used while cooking, provides a +8 bonus to saves vs. poison from consuming the food cooked.",
  },
  {
    id: 2, //Key for jsx
    name: "Death Shroud",
    description: "Cover the face of a corpse as it is buried.",
    whenInfused:
      "While worn by a living person, they are invisible to undead, and can see in the dark. Roll a d20 each day worn or time removed, on a result of 1, this gets tattered, next 1 it disintegrates.",
  },
  {
    id: 3, //Key for jsx
    name: "Archer's Bracers",
    description: " Protects arms while using a bow.",
    whenInfused:
      "Provide a +1 bonus to damage with a bow and arrows, and a +1 bonus to AC against missile fire.",
  },
  {
    id: 4, //Key for jsx
    name: "Rat Statuette",
    description: " Decorate a space.",
    whenInfused:
      "When the head is planted on a level surface, and fresh blood is poured over this statuette, all sounds within a 20' radius will be contained within the circle. This effect lasts for eight hours. If a Dog or Cat Statuette is also active in this region, the two will be negated, and the sound of a frustrated dog or cat will instead be heard for eight hours.",
  },
  {
    id: 5, //Key for jsx
    name: "Brittle Knife",
    description: " Engage in desperate combat.",
    whenInfused:
      "Does 1d3 dmg. When attacking an outsider (elemental, angel, demon, devil, etc.), on a natural 20, does 1d20 dmg. If the damage roll is 20, it shatteres, doing 100 damage.",
  },
  {
    id: 6, //Key for jsx
    name: "Dancer's Slippers",
    description: "Move gracefully.",
    whenInfused:
      "Wearer gets +1 to balance checks and checks to impress by dancing, but when moving through rough terrain, have a 1 in 10 chance per turn of being damaged, then destroyed. Repairing takes 1 hour, a needle and thread.",
  },
  {
    id: 7, //Key for jsx
    name: "Abjurer's ring",
    description: " Protect against magic and supernatural threats.",
    whenInfused:
      "When the ring has been worn for a month by a magic user, it gains a spell slot. If the slot is empty, it provides a first save against any first level targeting the wearer. If that save is successful, the wearer is unaffected, and the slot is filled with that spell. The wearer can then activate the ring to provide a +2 bonus for ten minutes to all saves against magic or effects caused by dragons or outsiders (angels, demons, devils, elementals, etc.)",
  },
  {
    id: 8, //Key for jsx
    name: "Bone Prayer Beads",
    description: "Used to count prayers.",
    whenInfused:
      "When used for a prayer, provide bonus of protection from evil for one hour once each week. User must donate level x 10 gp to this religion's temple before it can be used again.",
  },
  {
    id: 9, //Key for jsx
    name: "New Smoking Pipe",
    description: "Calm and focus.",
    whenInfused:
      "When the character sits with the pipe for at least three turns, they get to use the better of two rolls on the next non-combat action they take.",
  },
  {
    id: 10, //Key for jsx
    name: "Thug's Cudgel",
    description: "Solves problems.",
    whenInfused:
      " As mace, provides +1 damage to to attacks against humans, demi-humans, and humanoids, and +1d6 for sneak attacks against them.",
  },
  {
    id: 11, //Key for jsx
    name: "Silver Amulet",
    description: "Protects against something.",
    whenInfused:
      "When worn, prevent the wearer from being turned into a lycanthrope, and reduce damage from lycanthrope's attacks by 2.",
  },
];
