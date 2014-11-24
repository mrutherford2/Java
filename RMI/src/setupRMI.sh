#!/bin/bash
echo "Compiling Server and Client files for RMI"

javac RMI/RMIServer.java
javac RMI/RMIServerImpl.java
javac RMI/RMIClient.java
javac RMI/RMIInterface.java
echo "Compling finished, feel free to execute the program"
