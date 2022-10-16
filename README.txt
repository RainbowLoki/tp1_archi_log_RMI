LISEZ-MOI : TP1 Architecture Logicielle

Réalisé par :	Arthur SAPIN
		Wided MEFLAH

Vous trouverez dans l'archive courante le diagramme UML sous forme de fichier .png et le compte rendu sous forme de fichier HTML.

Lien du dépôt GitHub : https://github.com/RainbowLoki/tp1_archi_log_RMI


Déploiement :
- Le projet peut être compilé et lancé à l'aide du fichier Makefile du répertoire courant.
	- Ouvrez un terminal dans le répertoire parent du projet.
	- "make comp" permet de compiler le code source.
	- "make serveur" permet de lancer le serveur.
	- "make client" permet de lancer un processus client; vous pouvez en lancer plusieurs de cette façon.

- Si vous rencontrez des problèmes avec le fichier Makefile, le projet peut être ouvert et exécuté avec l'IDE Eclipse.
	- Importez les dossiers RMI et Client comme deux projets séparés.
	- Exécutez la classe Serveur.java
	- Exécutez la classe Client.java

Mode d'emploi :
	- Le serveur initialise toujours le cabinet avec quelques Animaux dedans, mais vous pouvez en rajouter.
	- Entrez des entiers de 1 à 6 dans l'interface de la console pour tester les différentes fonction du client.
	- Le processus client s'arrête lorsque vous tapez 6.
	- Pour le serveur, il faut l'arrêter en fermant le terminal ou en utilisant la commande Ctrl+C dans le terminal.