Jeu du Donjon
BELLAMY Matthieu - HEMBERT Romain
Groupe 1
29/09/2015


### 1/ Introduction

Cette application est un jeu de Donjon. Le joueur doit sortir du donjon en évitant les pièges, ouvrir les différentes portes avec des clés et battre des monstres.


### 2/ Usage

Pour lancer l'application, allez dans le dossier du .jar et tapez :
java -jar Dungeon.jar [Level File]
Remplacez [Level File] par un chermin vers un fichier de level (dans le dossier levels par exemple)

Pour contrôler le joueur, plusieurs commandes sont possibles :
- Describe -> Décris la pièce dans laquelle se trouve le joueur
- Fight -> Attaque le monstre de la pièce ... s'il y en a un ! (Les armes sont utilisées automatiquement)
- Get:[Objet] -> Ramasse l'objet [Objet] situé dans la pièce et le place dans l'inventaire du joueur (remplacez [Objet] par le nom de l'objet)
- Go:[Direction] -> Déplace le joueur vers la porte [Direction] (remplacez [Direction] par la direction de la porte)
- Inventory -> Affiche l'inventaire du joueur
- Use:[Objet] -> Utilise l'objet [Objet] de l'inventaire (remplacez [Objet] par le nom de l'objet)

Plusieurs objets peuvent être toruvés dans les donjons :
- Potions : régénère de la vie au joueur
- Epées : augmente le nombre de dégâts lors des combats
- Clés : permettent d'ouvrir une porte chacune

### 3/ Architecture

Les classes "Door", "Dungeon" et "Room" définissent le jeu ainsi que le plateau de jeu.
Les classes "Entity" et "Item" sont des classes abstaites générales pour représenter respectivement les entités (monstres et joueurs) et les items (clés, potions et épées). vous pouvez donc assez facilement créer votre propre entité ou item.

### 4/ Code sample

Le code ci-dessous est la construction d'un niveau en fonction d'un fichier de configuration passé en paramètre. Le fichier doit respecter une certaine norme.

private void generateLevel(BufferedReader file) throws NotConformFileException, IOException{
  	String line = file.readLine();
	//Vérification de la première ligne du fichier
	if(!line.equals("# DUNGEON LEVEL CONFIG")){
	  	 throw new NotConformFileException("The first line is not \"# DUNGEON LEVEL CONFIG\"");
	}
	
	//Création des pièces
	while((line = file.readLine()) != null){
		if(line.charAt(0) == '#') continue;
		if(line.charAt(0) == '-') break;
		Room r = new Room(line.trim());
		this.rooms.add(r);
	}
	
	//Création des portes	
	while((line = file.readLine()) != null){
		[...]
		String[] parts = line.split(",");
		new Door(parts[0].trim(), this.getRoom(parts[1].trim()), this.getRoom(parts[2].trim()), parts[3].trim(), parts[4].trim());
	}
	
	//Création et ajout des items dans les pièces
	while((line = file.readLine()) != null){
		[...]
		String[] parts = line.split(",");

		Item i = Item.getItem(parts[2].trim(), parts[3].trim());
		this.getRoom(parts[1].trim()).addItem(parts[0].trim(), i);
	}
	
	//Création et ajout des montres dans les pièces	
	while((line = file.readLine()) != null){
		[...]
		// Split et création d'une instance de Monster
		this.getRoom(parts[0].trim()).setMonster(m);
	}
}

La fonction ci-dessous est l'utilisation d'un desgn pattern appelé Factory. Il sert à instancier un objet en passant juste le nom de l'objet en argument.

public static Item getItem(String itemName, String attribute){
  	//Le switch sert à retourner la bonne instance d'objet avec le bon attribut
	switch(itemName.toLowerCase()){
		case "key":
			return new Key(attribute);
		case "potion":
			return new Potion(Integer.parseInt(attribute));
		case "weapon":
			return new Weapon(Integer.parseInt(attribute));
		default:
			return null;
	}
}
