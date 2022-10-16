all: comp

comp:
	javac -d TP1_architecture_logicielle_COMMONS/bin -cp TP1_architecture_logicielle_COMMONS/bin/commons TP1_architecture_logicielle_COMMONS/src/commons/*.java

	javac -d TP1_architecture_logicielle_CLIENT/bin -cp TP1_architecture_logicielle_COMMONS/bin TP1_architecture_logicielle_CLIENT/src/codebase/*.java
	javac -d TP1_architecture_logicielle_CLIENT/bin -cp TP1_architecture_logicielle_COMMONS/bin/commons TP1_architecture_logicielle_CLIENT/src/main/*.java

	javac -d TP1_architecture_logicielle_RMI/bin -cp TP1_architecture_logicielle_COMMONS/bin/commons TP1_architecture_logicielle_RMI/src/main/*.java

serveur:
	java -cp "TP1_architecture_logicielle_COMMONS/bin/:TP1_architecture_logicielle_CLIENT/bin/:TP1_architecture_logicielle_RMI/bin/" main.Serveur

client:
	java -cp "TP1_architecture_logicielle_COMMONS/bin/commons/:TP1_architecture_logicielle_CLIENT/bin/" main.Client 